package com.ssafy.book.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.book.model.dto.Book;
import com.ssafy.book.model.dto.PageBean;

public interface BookDao {
	public List<Book> searchAll(PageBean bean) throws SQLException;
	public int totalCount(PageBean bean) throws SQLException;
	public Book search(String isbn)	throws SQLException;
	public void remove(String isbn)	throws SQLException;
	public void update(Book book)	throws SQLException;
	public void insert(Book book)	throws SQLException;
}
