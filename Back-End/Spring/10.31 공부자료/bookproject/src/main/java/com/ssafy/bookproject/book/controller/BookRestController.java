package com.ssafy.bookproject.book.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.bookproject.book.model.dto.Book;
import com.ssafy.bookproject.book.model.dto.BookException;
import com.ssafy.bookproject.book.model.dto.PageBean;
import com.ssafy.bookproject.book.model.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController // Controller내에서 작성하는 모든 메서드에 기본적으로 @ResponseBody로 출력됨.
@RequestMapping("/rest") // 요청하는 자원(Domain)명을 붙인다.
@Api(value = "Book REST-ful위한 API", description = "SSAFY 도서 정보")
@CrossOrigin(origins = { "*" }) // 다른 서버에서 Ajax 요청이 와도 서비스 되도록 설정
//기본적으로 같은 서버, 같은 context(webApp) 끼리만 사용가능, 브라우저에서 prefly해주고 서버가 허용해줘야하는데 그것이 바로 crossOrigin
public class BookRestController {
	private Logger logger = LoggerFactory.getLogger(BookRestController.class);
	private BookService bookService;

	private static final String SUCCESS = "success";

	public BookRestController(BookService bookService) {

		this.bookService = bookService;
	}

	/**
	 * ResponseEntity 응답 코드 + 응답 데이터를 전송하기 위한 객체
	 * 
	 * @param bean
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> searchAll(PageBean bean) {
		logger.debug("book.searchAll............bean:{}", bean);
		List<Book> books = bookService.searchAll(bean);
		logger.debug("book.searchAll............books:{}", books);
		logger.debug("book.searchAll............bean:{}", bean);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("books", books);
		result.put("page", bean);

		if (books != null && !books.isEmpty()) {
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

	}

	// 충돌방지를 위해 pathVariable로 param을 전달, pathVariable로 주는 데이터는 생략 불가
	@ApiOperation(value = "isbn에 해당하는 책 정보 조회", notes = "도서번호(isbn)에 해당하는 도서 정보 조회")
	@GetMapping("/{isbn}")
	public ResponseEntity<?> search(@PathVariable String isbn) {
		logger.debug("book.search............ isbn:{}", isbn);
		Book book = bookService.search(isbn);
		logger.debug("book.search............ book:{}", book);

		if (book != null) {
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	
	@ApiOperation(value="책 정보 등록", notes="도서 정보를 등록한다.")
	@ApiResponse(code = 200, message="success")
	@PostMapping
	public ResponseEntity<String> regist(@RequestBody Book book){
		logger.debug("Book.regist.............. book:{}",book);
		bookService.insert(book);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	
	
	
	@ApiOperation(value="책 정보 수정", notes="도서 정보를 수정 한다.")
	@ApiResponse(code = 200, message="success")
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Book book){
		logger.debug("Book.regist.............. book:{}",book);
		bookService.update(book);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	@ApiOperation(value="책 정보 삭제", notes="도서 정보를 삭제 한다.")
	@ApiResponse(code = 200, message="success")
	@DeleteMapping("/{isbn}")
	public ResponseEntity<String> remove(@PathVariable String isbn){
		logger.debug("Book.regist.............. isbn:{}",isbn);
		bookService.remove(isbn);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handler(Exception e) {
		e.printStackTrace();
		logger.error("book.error...............msg:{}", e.getMessage());

		// error메세지가 한글인 경우 깨지므로 한글 처리를 위한 설정
		HttpHeaders resHeader = new HttpHeaders();
		resHeader.add("Content-Type", "application/json;charset=UTF-8");
		String errorMsg = "";
		if (e instanceof BookException) {
			errorMsg = e.getMessage();
		} else {
			errorMsg = "처리 중 오류 발생";
		}
		return new ResponseEntity<String>(e.getMessage(), resHeader, HttpStatus.FAILED_DEPENDENCY);

	}
}
