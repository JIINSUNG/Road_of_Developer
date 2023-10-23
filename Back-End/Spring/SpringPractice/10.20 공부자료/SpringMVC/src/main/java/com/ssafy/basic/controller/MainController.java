package com.ssafy.basic.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.basic.board.vo.Board;

@Controller
// @RequestMapping("/url") : 현재 controller의 기본 경로 지정 
public class MainController {
	/**
	 * 1. 요청 매핑 처리
	 * 
	 * @RequestMapping - 요청 url을 key로, 처리할 함수를 value로하여 HandlerMapper에 등록하는
	 *                 Annotation
	 * 
	 *                 - 형식 @RequestMapping(value={"url", "url"}, method=전송방식) -
	 *                 method를 생략하면 모든 전송방식을 서비스 한다. - spring 4.x 버전부터 전송 방식에 따른
	 *                 Annotation이 추가됨. @GetMapping(value={"url","url"}) : get방식
	 *                 처리 @PostMapping(value={"url","url"}) : post방식 처리 ... 2.
	 *                 Handler 메서드의 인자 정보 => 요청 데이터 - 클라이언트의 요청을 처리하기 위한 정보들을 인자로
	 *                 받는다
	 * 
	 *                 2.1 String - 인자명으로 요청데이터를 추출한 데이타가 전달된다. String 인자명 =
	 *                 request.getParameter("인자명") - 요청 데이타 이름으로 데이타가 전송되지 않거나 요청
	 *                 packet에 요청 데이터 이름이 없어도 error가 발생하지 않는다.
	 * 
	 *                 2.2 Primitive type - 인자명으로 요청데이터를 추출 후 해당 타입으로 변경해서 데이터가
	 *                 전달된다. - ex) int price int price =
	 *                 Integer.parseInt(request.getParameter("price")); - 인자명에 해당하는
	 *                 요청 데이터가 요청 packet에 없으면 500 error (서버에러)가 발생한다. 인자명에 해당하는 요청
	 *                 데이터명이 요청 packet에 있지만 데이터가 없는 경우 400 error 발생 요청 데이터가 해당
	 *                 format이 아닌 경우 400 에러 발생
	 * 
	 *                 2.3 @RequestParam(value='요청데이터명', required=true/false,
	 *                 defaultValue="") String or Primitive value - 추출할 요청 데이타 명을 지정
	 *                 - 생략하면 인자명으로 요청 데이터를 추출 require - true : 요청 데이터가 없는 경우 error
	 *                 발생
	 * 
	 * 
	 *                 defaultValue - 요청 데이터가 전달 되지 않는 경우 설정한 기본 값으로 전달 된다.
	 * 
	 *                 2.4 Model - Model은 interface로 직접 생성할 수 없고 인자로만 전달 받는다 - 모델을
	 *                 수행한 결과를 저장하는 역할 - scope은 request이다.
	 * 
	 *                 2.5 @RequestParam Map - request packet에 있는 모든 요청 데이타를 추출해서
	 *                 Map에 저장됨.
	 * 
	 *                 2.6 DTO(Data Transfer Object = VO) - 지정한 DTO 객체를 기본 생성자로 생성하고
	 *                 객체에 선언된 모든 속성에 대해 요청데이타로 추출 후 setter로 저장한 후 request에
	 *                 클래스명(첫글자만 소문자로바뀐 기존 클래스명) 으로 저장한다.
	 * 
	 * 
	 *                 ex) Board b
	 * 
	 *                 Board b = new Board();
	 *                 b.setNo(Integer.parseInt(request.getParameter("no")));
	 *                 b.setId(request.getParameter("id")); ....// 모든 속성이름으로 요청 데이타를
	 *                 추출해서 setting request.setAttribute("board", b);
	 * 
	 *                 2.7 @ModelAttribute("이름") DTO - 지정한 DTO 객체를 생성하고 객체에 선언된 모든
	 *                 속성에 대해 요청데이타로 추출 후 setter로 저장한 후 request에 지정한 이름으로 저장한다.
	 * 
	 * 
	 *                 @ModelAttribute("b") Board board
	 * 
	 *                 Board board = new Board();
	 *                 board.setNo(Integer.parseInt(request.getParameter("no")));
	 *                 board.setId(request.getParameter("id")); ....// 모든 속성이름으로 요청
	 *                 데이타를 추출해서 setting request.setAttribute("b", board);
	 * 
	 * 
	 *                 2.8 Servlet 객체들을 인자로 전달 받기 HttpServletRequest,
	 *                 HttpServletResponse, Reader, Writer, ServletInputStream,
	 *                 ServletOutputStream, HttpSession
	 * 
	 *                 2.9 MultipartFile - 업로든된 파일 정보를 담기위한 클래스 - 요청 packet에 있는 파일
	 *                 정보를 추출해서 MultipartFile타입으로 전달하기 위한 설정 2.9.1 pom.xml에 파일 정보를
	 *                 추출할 라이브러리를 추가 commons-io-xxx.jar commons-fileupload-xxx.jar
	 * 
	 *                 2.9.2 servlet-context.xml(web을 위한 Bean configuration xml 파일)에
	 *                 multipartResolver를 설정한다. multipartResolver는 request에서 파일 정보를
	 *                 추출해서 MultipartFile 객체에 담아서 전달한다.
	 * 
	 * 
	 *                 2.10 @PathVariable 타입 변수명 - url경로에서 데이타를 추출
	 *                 http://ip:port/contextPath/servletPath/data <=REST API
	 * 
	 *                 2.11 RedirectAttributes - RedirectAttributes에 저장한 데이타는
	 *                 response.sendRedirect("url")로 이동한 페이지에서 데이타를 유지할 수 있다.
	 * 
	 * 
	 *                 3. handler 메서드의 리턴 - 응답을 처리하기 위한 객체(View 정보)를 리턴한다.
	 * 
	 *                 3.1 String - 이동할 View에 대한 url을 문자열로 리턴한다. 형식] redirect로 이동 :
	 *                 ==> ViewResolver가 동작하지 않으므로 이동할 모든 경로를 지정해야 한다.
	 *                 "redirect:url" : redirect 생략하면 안됨
	 * 
	 *                 forward로 이동 : ==> ViewResolver가 url에 해당하는 View를 찾아 service한다.
	 *                 "forward:url" or "url" : forward가 default라 forward는 생략해도 됨
	 * 
	 * 
	 *                 3.2 void, Model, Map => view에 대한 정보가 없으므로 
	 *                 - 요청 url중에 .이후를 제거한 이름을 view 이름으로 인식 
	 *                 - ViewResolver를 설정해서 view이름을 완성해야 한다.
	 *                 ex) @PostMapping("/boardInsert.do") 인 경우 view 경로 /boardInsert
	 * 
	 * 
	 *                 3.3 ModelAndView - Model을 수행한 결과와 view 정보를 담은 객체를 리턴 Model을
	 *                 수행한 결과는 request에 저장되고 view 정보로 이동
	 * 
	 * 
	 *                 3.4 객체(DTO, Map, List, 배열) - URL을 통해 View로 이동하지 않고 View를 생성한
	 *                 후 객체를 JSON or xml로 변형해서 직접 출력 ==> RestFul 서비스를 위해 객체 정보를 JSON
	 *                 or xml로 출력 - @ResponseBody 추가 - 직접 출력하는 Annotation - JSON or
	 *                 xml 로 변형해주는 라이브러리 추가 jackson-databind-xxx.jar을 pom.xml에 추가
	 * 
	 *                 4. 예외 처리 
	 *                 	4.1 해당 Controller에서 발생한 오류들만 공통으로 처리 하기
	 *   			   	@ExceptionHandler 처리 함수
	 * 
	 *                   4.2 Context내에서 발생하는 모든 오류를 공통으로 처리 하기
	 * 					@ControllerAdvice 클래스
	 * 
	 * 					500 서버에러
	 * 					404 URL 없음
	 * 					405 Request Method 에러
	 * 					403 Forbidden, 접근권한 에러
	 * 					
	 */
	
	// 4. 에러 처리 
//	@ExceptionHandler
//	public ModelAndView handler(Exception e)
//	{
//		ModelAndView mav = new ModelAndView("error");
//		mav.addObject("msg", e.getMessage());
//		return mav;
//	}
	
	@GetMapping("/error")
	public String errorTest() {
		if(true) throw new RuntimeException("의도적인 에러 발생");
		return "hello";
	}
	
	// 3.3 ModelAndView 
	@GetMapping("/hello3_3")
	public ModelAndView hello3_3(String msg) {
		ModelAndView mav = new ModelAndView("hello");
		System.out.println("요청 데이터 : " + msg);
		mav.addObject("msg", msg);
		return mav; // redirect로 지정해주지 않으면 기본 forward로 이동. 
	} 
	
	

	// 3.2 voidindex.jsp에서 시작
		@GetMapping("/hello")
		public void hello(String msg, Model model) {
			System.out.println("요청 데이터 : " + msg);
			model.addAttribute("msg", msg); 
			// 이동할 view 정보가 없으므로 ViewResolver에 의해 요청 url로 view를 찾아
			// forward로 이동. 
		} 
	
	// 3.1.2 forward index.jsp에서 시작
	@GetMapping("/forwardTest")
	public String forwardTest(String msg, Model model) {
		System.out.println("요청 데이터 : " + msg);
		model.addAttribute("msg", msg); // forward에 저장한 데이터가 유지됨.
		return "hello"; // viewresolver에 의해 url이 완성
	}	
	
	
	// 3.1.1 redirect index.jsp에서 시작
	@GetMapping("/redirectTest")
	public String redirectTest(String msg, Model model) {
		System.out.println("요청 데이터 : " + msg);
		model.addAttribute("msg", msg); // redirect는 request가 유지되지 않음
		return "redirect:redirect.jsp"; // webapp/redirect.jsp로 이동, WEB-INF로 들어갈수없음
	}

	// 2.7 @ModelAttribue
	@GetMapping("/regist2_7")
	public String regist2_7() {
		return "regist2_7"; // regist2_6.jsp로 이동
	}

	@PostMapping("/regist2_7")
	public String regist2_7(@ModelAttribute("b") Board b) { // 기본적으로 model에 추가된다.
		System.out.println("요청데이터");
		System.out.println(b);
		return "regist2_7"; // regist2_6.jsp로 이동

	}

	// 2.6 DTO
	@GetMapping("/regist2_6")
	public String regist2_6() {
		return "regist2_6"; // regist2_6.jsp로 이동
	}

	@PostMapping("/regist2_6")
	public String regist2_6(Board b) { // 기본적으로 model에 추가된다.
		System.out.println("요청데이터");
		System.out.println(b);
		return "regist2_6"; // regist2_6.jsp로 이동

	}

	// 2.5 @RequestParam Map
	@GetMapping("/regist2_5")
	public String regist2_5() {
		return "regist2_5"; // regist2_5.jsp로 이동
	}

	@PostMapping("/regist2_5")
	public String regist2_5(@RequestParam Map<String, String> map, Model model) {
		System.out.println("요청데이터");
		System.out.println(map);
		model.addAttribute("map", map); // 기본적으로 model에 추가되지 않으므로 필요하면 따로 추가해줘야함
		return "regist2_5"; // regist2_5.jsp로 이동

	}

	// 2.4 Model (ToDo: 추후 작성예정)

	/*
	 * 2.3 @RequestParam String or Primitive http://localhost:8080/basic/hello2-32
	 * //정상 <== 기본값 전달 http://localhost:8080/basic/hello2-32?msg=1000 //정상
	 */
	@GetMapping("/hello2-32")
	public String hello2_32(@RequestParam(defaultValue = "5000") int msg) {
		System.out.println("msg :" + msg);
		return "hello";
	}

	/*
	 * 2.3 @RequestParam String or Primitive http://localhost:8080/basic/hello2-31
	 * 400 error 발생 http://localhost:8080/basic/hello2-31?msg= //정상
	 * http://localhost:8080/basic/hello2-31?msg=5000 //정상
	 */
	@GetMapping("/hello2-31")
	public String hello2_31(@RequestParam(required = true) String msg) {
		System.out.println("msg :" + msg);
		return "hello";
	}

	/*
	 * 2.2 int 인자 http://localhost:8080/basic/hello2-1 //500 error 발생
	 * http://localhost:8080/basic/hello2-1?msg= //400 error 발생
	 * http://localhost:8080/basic/hello2-1?msg=hello //400 error 발생
	 * http://localhost:8080/basic/hello2-1?msg=5000 //정상
	 */
	@GetMapping("/hello2-2")
	public String hello2_2(int msg) {
		System.out.println("msg :" + msg);
		return "hello";
	}

	// 1.1 @RequestMapping 예제
	@RequestMapping(value = "/hello1-1", method = RequestMethod.GET)
	public String hello1_1() {
		// InternalResourceViewResolver에 의해 /WEB-INF/view/hello.jsp로 url이 완성됨.
		return "hello";
	}

	// 1.2 @RequestMapping 예제
	@GetMapping("/hello1-2")
	public String hello1_2() {
		return "hello";
	}

	// 2.1 String 인자
	/*
	 * http://localhost:8080/basic/hello2-1 //error 발생안함
	 * http://localhost:8080/basic/hello2-1?msg= //error 발생안함
	 */
	@GetMapping("/hello2-1")
	public String hello2_1(String msg) {
		System.out.println("msg :" + msg);
		return "hello";
	}

}
