import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.book.model.dto.Book;
import com.ssafy.book.model.dto.PageBean;
import com.ssafy.book.model.service.BookService;

public class DITest { 
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("com/ssafy/config/applicationContext.xml");
		
		BookService bookService = con.getBean(BookService.class);
		
		PageBean bean = new PageBean("all", null, 1); 
//		1, 2 ==> 페이지수 
		List<Book> books = bookService.searchAll(bean);
		
		for(Book book : books)
		{
			System.out.println(book);
			
		}
	}
}
