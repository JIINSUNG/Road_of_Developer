# Spring DI (Dependency Injection)

### 빈 생성 범위

- 싱글톤 빈 (Singleton Bean)
  - 빈은 기본적으로 싱글톤으로 생성
  - 즉, 컨테이너가 제공하는 빈은 항상 동일
  - 만약, 새로운 인스턴스를 받으려면 scope를 prototype으로 설정

| 범위      | 설명                                        |
| --------- | ------------------------------------------- |
| singleton | 스프링 컨테이너당 하나의 인스턴스 빈만 생성 |
| prototype | 컨테이너 빈 요청시마다 새로운 인스턴스 생성 |
| request   | Request별로 새로운 인스턴스 생성            |
| session   | Session별로 새로운 인스턴스 생성            |

### 빈 설정 방법

- XML Document
  - XML문서 형태로 빈 설정 메타 정보 기술
  - \<bean> 태그를 통해 세밀한 제어
- Java Code
- Annotation

  - 빈으로 사용될 클래스에 annotation을 부여해 자동으로 빈 등록
  - 오브젝트 빈 스캐너로 빈 스캐닝 통해 자동 등록

    - 기본적으로 클래스 이름을 빈의 아이디로 사용
    - 클래스 이름의 첫글자만 소문자로 바꿔 사용
    - annotation 사용시 XML에 component-scan 설정 필수!

  - annotation 종류

  | Stereotype | 적용대상                        |
  | ---------- | ------------------------------- |
  | Repository | Dao, Repository클래스에 사용    |
  | Service    | Service Layer 클래스에 사용     |
  | Controller | MVC Controller에 사용           |
  | Component  | 위 타입 외 일반적인 경우에 사용 |

## 실습하기

---

### XML문서 이용 방식

- 이름은 상관없지만 보통 applicationContext.xml 파일 이용.
- Application에서 사용할 Spring자원들 설정
- Root tag는 \<beans>
- 스프링 컨테이너에 등록할 객체를 정의하는데 \<bean> 태그이용
  - bean 기본속성
    - name : 호출 할 이름
    - id : 주입 받을 곳에서 호출할 이름 (유일 값)
    - class : 주입할 객체의 클래스
    - factory-method : singleton 패턴으로 작성된 객체의 factory-method 호출
    - bean 내부
      - constructor-arg
        - 생성자 인자
      - property
        - 속성
      - ref
        - 참조

### constructor-arg, ref 이용 방식

```
<?xml version="1.0" encoding="UTF-8"?>
<beans 속성 생략 >
	<bean id='dbutil'		class="com.ssafy.book.util.DBUtil"/>

  // bookDao 생성자인자로 dataSource, dbutil 부여
	<bean id='bookDao'		class="com.ssafy.book.model.dao.BookDaoImpl">
		<constructor-arg	ref='dataSource'/>
		<constructor-arg	ref='dbutil'/>
  // 인자의 순서도 지정 가능 값 : 0~ 인덱스 지정
  // 		<constructor-arg index="값"	ref='dataSource'/>
	</bean>

  // bookService 생성자인자로 bookDao 부여
	<bean id='bookService'	class="com.ssafy.book.model.service.BookServiceImpl">
		<constructor-arg	ref='bookDao'/>
	</bean>

</beans>

```

### main

```
		ApplicationContext con =
				new ClassPathXmlApplicationContext("com/ssafy/config/applicationContext.xml");

		BookService bookService = con.getBean(BookService.class);

		PageBean bean = new PageBean("all", null, 2);
		List<Book> books = bookService.searchAll(bean);

```

---

### property, ref 이용방식

```
<beans>

	<bean id='dbutil'		class="com.ssafy.book.util.DBUtil"/>

	<bean id='bookDao'		class="com.ssafy.book.model.dao.BookDaoImpl">
		<property name='ds'		ref='dataSource'/>
		<property name='dbutil'	ref='dbutil'/>
	</bean>

	<bean id='bookService'	class="com.ssafy.book.model.service.BookServiceImpl">
		<property name='dao'	ref='bookDao'/>
	</bean>

</beans>
```

### main

```
		ApplicationContext con =
				new ClassPathXmlApplicationContext("com/ssafy/config/applicationContext2.xml");

		BookService bookService = con.getBean(BookService.class);

		PageBean bean = new PageBean("all", null, 2);
		List<Book> books = bookService.searchAll(bean);

```

---

### autowire 이용방식

```
<beans>
autowire
 - 의존 관계를 자동 주입
 byType : 속성의 타입과 동일한 타입으로 등록된 bean을 자동 주입.
 	      주의) 동일한 타입의 객체가 2개 이상 등록되어 있는 경우 error 발생
 constructor : 생성자의 인자 타입과 동일한  타입으로 등록된 bean을 자동 주입.
 byName : 속성의 이름과 bean 이름(id or name)과 동일한 bean을 자동 주입.

	<bean id='bookDao'						class="com.ssafy.book.model.dao.BookDaoImpl"		 	autowire="byType"/>
	<bean id='bookDao2'	 name="dao dao2"   	class="com.ssafy.book.model.dao.BookDaoImpl"		 	autowire="byType"/>
	<bean id='bookService'	class="com.ssafy.book.model.service.BookServiceImpl"					autowire="byName"/>
<beans>

```

### main

```
		ApplicationContext con =
				new ClassPathXmlApplicationContext("com/ssafy/config/applicationContext3.xml");

		BookService bookService = con.getBean(BookService.class);

		PageBean bean = new PageBean("all", null, 2);
		List<Book> books = bookService.searchAll(bean);

```

---

### default-autowire 이용방식

```
<beans
default-autowire="byType"
>
bean의 속성으로 autowire 지정해주지 않아도 디폴트로 지정해줌
	<bean id='dbutil'		class="com.ssafy.book.util.DBUtil"/>

	<bean id='bookDao'		class="com.ssafy.book.model.dao.BookDaoImpl"		 	/>
	<bean id='bookService'	class="com.ssafy.book.model.service.BookServiceImpl"	/>

</beans>
```

### main

```
		ApplicationContext con =
				new ClassPathXmlApplicationContext("com/ssafy/config/applicationContext4.xml");

		BookService bookService = con.getBean(BookService.class);

		PageBean bean = new PageBean("all", null, 2);
		List<Book> books = bookService.searchAll(bean);

```

---

### annotation 이용방식

```
<beans>
	<context:component-scan base-package="경로.*"/>
<beans>
```

### DaoImpl

```
@Repository("dao")
public class BookDaoImpl implements BookDao {

	@Autowired
	private DataSource ds;

	@Autowired
	private DBUtil dbutil;
```

### ServiceImpl

```
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	@Qualifier("dao")
	private BookDao dao;
```

### main

```
		ApplicationContext con =
				new ClassPathXmlApplicationContext("com/ssafy/config/applicationContext.xml");

		BookService bookService = con.getBean(BookService.class);

		PageBean bean = new PageBean("all", null, 2);
		List<Book> books = bookService.searchAll(bean);
```

---
