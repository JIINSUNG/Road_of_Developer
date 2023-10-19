# AOP (Aspect Oriented Programming)

### 개요

- AOP는 문제 해결을 위한 핵심 관심사항, 전체에 적용되는 공통관심사항을 기준으로 나눠 프로그래밍 (공통관심사항 : 로깅, 트랜잭션, 보안, DB연결 등)
    - AOP는 application에서 핵심기능에서 부가기능을 분리
        - 분리한 부가기능을 Aspect라는 모듈 형태로 만들어 설계하고 개발.
        - 핵심기능을 설계하고 구현할때 객체지향적 가치를 지킬 수 있도록 도와줌
        - 공통기능 변경시 bean config만 수정해주면 됨.

### AOP의 적용예시

- 간단한 메소드 성능 검사
    - 매번 성능검사를 위한 System.curentTime() 등 사용할 필요가 없음
- 트랜잭션 처리
    - 매번 사용하는 트랜잭션 (try catch) 코드는 번거롭고 소스를 복잡하게 만드는데
    - AOP는 이를 해결해줌
- 예외 반환
    - 구조가 안좋은 예외 발생시 그걸 잡아서 잘 정의 된 예외 계층 구조로 변환해 던져줌
- 아키텍쳐 검증
- 메소드락 Aspect
- 데드락 예외시 재시도 하는 Aspect
- 로깅, 인증, 권한 등 기능

### 스프링 AOP

- 용어정리
    - Target
        - 핵심 기능 모듈 (공통모듈을 부여할 대상)
    - Advice
        - aspect를 적용할 시점 (Before, aroudm After, AfterReturning, AfterThrowing 등)
        - Target에 제공할 부가기능을 담고 있는 모듈.
    - JoinPoint
        - 핵심모듈에 Aspect를  적용하기 위해 연결한 지점
        - Target(핵심 모듈)에 관한 정보 (이름, 인자정보, 리턴정보,실행권한,오류정보 등) 처리
    - Pointcut
        - Aspect 적용시킬 핵심모듈을 찾는것
        - Aspectj 표현식을 이용해서 찾음
    - Aspect (공통모듈)
        - 여러 객체에서 공통으로 적용되는 공통 관심사항 (트랜잭션, 로깅, 보안)
        - Advice + Pointcut = Advisor(스프링 AOP에서 사용하는 용어)
        - 싱글톤 형태의 객체로 존재.
    - Weaving
        - Aspect를 Target에 적용시키기
        - 어떤 Advice를 어떤 Pointcut에 적용시킬 것인지에 대한 설정

### Pointcut의 표현식

- execution : 메서드 실행 조인 포인트를 매칭
- within : 특정 타입 (interface, class) 내의 조인 포인트를 매칭
- args : 지정한 타입을 인자로 지정한 모든 인스턴스를 조인 포인트로 매칭
- this : 지정한 타입의 객체 (스프링 AOP 프록시) 조인 포인트를 매칭
- target : 지정한 타입의 객체 (스프링 AOP 프록시가 가르키는 실제 대상) 조인 포인트를 매칭

### 사용예시

- execution(함수)

* : 모든것

.. : depth 무관  

|  | modifer | 리턴타입 | 패키지명.클래스명.함수명(인자) |
| --- | --- | --- | --- |
| 대체  | 생략 | 생략, * | 생략,*,..   \ 생략, * \ *(..) |

| Pointcut | 선택된 JoinPoint |
| --- | --- |
| execution(public * *(..)) | public 메소드 실행 |
| executrion(* set*(..)) | 이름이 set으로 시작하는 모든 메서드 실행 |
| execution(* com.test.service.AccountService.*(..)) | AccountService 인터페이스의 모든 메서드 실행 |
| within(com.test.service.*) | service 패키지내 모든 결합점 |
| within(com.test.service..*) | service 패키지 및 하위 패키지의 모든 결합점 |
| this(com.test.service.AccountService) | AcoountService interface를 구현하는 프록시 개체의 모든 결합점 |
| target(com.test.service.AccountService) | AcoountService interface를 구현하는 대상 객체의 모든 결합점 |

| 설명 | Advice | 리턴타입 | 첫번째 인자 | 두번째 인자 | 비고 |
| --- | --- | --- | --- | --- | --- |
| 핵심 모듈 수행 되기 전 Aspect가 수행됨 | Before | void | JoinPoint | X |  |
| 핵심 모듈이 수행 된 후 Aspect가 수행됨 | After | void | JoinPoint | X 에러가나든안나든 무조건 수행 |  |
| 핵심 모듈 정상 수행후 결과가 리턴될때 Aspect가 수행됨 | After-Returning | void | JoinPoint | Object (리턴결과) 에러가 안난경우만 수행 |  |
| 핵심 모듈에 에러가 발생된 경우 Aspect가 수행됨 | After-Throwing | void | JoinPoint | Throwable (오류정보) 에러가 난 경우에만 수행 |  |
| 핵심 모듈  수행되기 전과 후에 Aspect가 수행됨 | Around | Object 핵심모듈을 수행한 결과
리턴하지 않으면 핵심모듈을 실제호출한곳에 결과가 전달되지 않음 | ProceedingJoinPoint (target 실행권한까지 있음) | X |  |

> JoinPoint : 핵심모듈과 Aspect의 수행시점이 명확하므로 Spring에서 실행을 관리 
proceedingJointPoint : 핵심모듈을 호출할 시점이 공통 모듈마다 다르므로 spring에서 관리할 수 없음, 개발자에게 핵심 모듈 수행할 권한을 제공.
>