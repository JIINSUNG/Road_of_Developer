package com.ssafy.book.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.book.model.dao.BookDao;
import com.ssafy.book.model.dto.Book;
import com.ssafy.book.model.dto.BookException;
import com.ssafy.book.model.dto.PageBean;
import com.ssafy.book.util.PageUtility;


public class BookServiceImpl implements BookService {
	
	private BookDao dao;
	
	public BookServiceImpl() {}
	
	public BookServiceImpl(BookDao dao) {
		super();
		this.dao = dao;
	}
	
	

	public BookDao getDao() {
		return dao;
	}

	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	@Override
	public void insert(Book book) {

	}

	@Override
	public void update(Book book) {

	}

	@Override
	public Book search(String isbn) {
		return null;
	}
	@Override
	public List<Book> searchAll(PageBean bean) {
		System.out.println("BookService.searchAll 수행 중...............");
		try {
			int total = dao.totalCount(bean);
			PageUtility page = new PageUtility(bean.getInterval(), total, bean.getPageNo(), null);
			bean.setPageLink(page.getPageBar());
			
			if(true) {
				throw new RuntimeException("런타임 error 발생");
			}
			
			return dao.searchAll(bean);
		} catch (SQLException e) {
			throw new BookException("책 목록 정보 조회 중 오류 발생");
		}
	}
	@Override
	public void remove(String isbn) {

	}
}
