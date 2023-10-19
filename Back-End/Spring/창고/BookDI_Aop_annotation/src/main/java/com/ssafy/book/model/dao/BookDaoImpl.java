package com.ssafy.book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.book.model.dto.Book;
import com.ssafy.book.model.dto.PageBean;
import com.ssafy.book.util.DBUtil;

@Repository("dao")
public class BookDaoImpl implements BookDao {
//@Autowired <-- 자동 주입 
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private DBUtil dbutil;
	
	@Override
	public List<Book> searchAll(PageBean bean) throws SQLException {
		Connection con= null;
		PreparedStatement stmt= null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			StringBuilder sb = new StringBuilder(50);
			sb.append(" select * from book where 1=1");
			
			String key = bean.getKey();
			String word= bean.getWord();
			int start  = bean.getStart();
			int end    = bean.getInterval();
			
			if( key!= null && !key.equals("all") && word!=null && !word.trim().equals("")) {
				if(key.equals("isbn")) {
					sb.append(" and isbn =? ");
				}else if(key.equals("title")) {
					sb.append(" and title like ?  ");
				}else if(key.equals("author")) {
					sb.append(" and author like ?  ");
				}
			}
			
			sb.append(" limit ? , ? ");
			stmt = con.prepareStatement(sb.toString());
			
			int idx = 1;
			if( key!= null && !key.equals("all") && word!=null && !word.trim().equals("")) {
				if(key.equals("isbn")) {
					stmt.setString(idx++, word);
				}else {
					stmt.setString(idx++, "%"+word+"%");
				}
			}
			
			stmt.setInt(idx++,start);
			stmt.setInt(idx++,end);
			rs = stmt.executeQuery();
			ArrayList<Book> books = new ArrayList<Book>(end);
			while(rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				books.add(book);
			}
			return books;
		} finally {
			dbutil.close(rs, stmt, con);
		}
	}

	@Override
	public int totalCount(PageBean bean) throws SQLException {
		Connection con= null;
		PreparedStatement stmt= null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			StringBuilder sb = new StringBuilder(50);
			sb.append(" select count(*) as cnt from book where 1=1");
			
			String key = bean.getKey();
			String word= bean.getWord();
			if( key!= null && !key.equals("all") && word!=null && !word.trim().equals("")) {
				if(key.equals("isbn")) {
					sb.append(" and isbn =? ");
				}else if(key.equals("title")) {
					sb.append(" and title like ?  ");
				}else if(key.equals("author")) {
					sb.append(" and author like ?  ");
				}
			}
			stmt = con.prepareStatement(sb.toString());
			
			int idx = 1;
			if( key!= null && !key.equals("all") && word!=null && !word.trim().equals("")) {
				if(key.equals("isbn")) {
					stmt.setString(idx++, word);
				}else {
					stmt.setString(idx++, "%"+word+"%");
				}
			}
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}
		} finally {
			dbutil.close(rs, stmt, con);
		}
		return 0;
	}

	@Override
	public Book search(String isbn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String isbn) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Book book) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(Book book) throws SQLException {
		// TODO Auto-generated method stub

	}

}
