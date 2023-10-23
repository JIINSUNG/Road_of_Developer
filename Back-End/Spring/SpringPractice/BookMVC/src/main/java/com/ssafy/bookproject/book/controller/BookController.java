package com.ssafy.bookproject.book.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.bookproject.book.model.dto.Book;
import com.ssafy.bookproject.book.model.dto.PageBean;
import com.ssafy.bookproject.book.model.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	private Logger logger = LoggerFactory.getLogger(BookController.class);

	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/insertBook")
	public void insertBook() {
	} // Get방식으로 insertBook을 요청하면 insertBook.jsp로 이동
	// 단순 이동시엔 리턴타입 void로 해줘도 상관없음. (book폴더에 있는 파일명과 같다는 조건하에)
	// void, Map, Mode 등 view 정보가 없을때는 ViewResolver가 prefix, suffix를 붙여 실행해줌

	@GetMapping("/listBook")
	public void listBook(Model model, PageBean bean) {
		logger.info("listBook.................................");
		logger.info("bean : {}", bean);
		List<Book> books = bookService.searchAll(bean);

		logger.info("books : {}", books);
		model.addAttribute("list", books);
	}

	@PostMapping("/insertBook")
	public String insertBook(Book book) {
		logger.info("insertBook..................");
		logger.info("요청 데이타 Book : {}", book);
		bookService.insert(book);
		return "redirect:/book/listBook";
	}

	@GetMapping("/searchBook")
	public void searchBook(String isbn, Model model) {
		logger.info("searchBook.................................");
		logger.info("요청데이타 isbn : {}", isbn);
		Book book = bookService.search(isbn);
		logger.info("search Book:{}", book);
		model.addAttribute("book", book);
	}
	
	@GetMapping("/updateBook")
	public void updateBook(String isbn, Model model) {
		logger.info("searchBook.................................");
		logger.info("요청데이타 isbn : {}", isbn);
		Book book = bookService.search(isbn);
		logger.info("search Book:{}", book);
		model.addAttribute("book", book);
	}
	
	@PostMapping("/updateBook")
	public String updateBook(Book book)
	{
		logger.info("updateBook............");
		logger.info("요청데이타 book : {}", book);
		bookService.update(book);
		return "redirect:/book/listBook";
	}
	
	@GetMapping("/removeBook")
	public String updateBook(String isbn) {
		logger.info("searchBook.................................");
		logger.info("요청데이타 isbn : {}", isbn);
		bookService.remove(isbn);
		return "redirect:/book/listBook";
	}
	
	

}
