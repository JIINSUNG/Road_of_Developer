# FrontEnd 프레임워크

### 들어가기 앞서

- 의존성
  - 한 요소가 다른 요소에게 의존하는 관계.
  - 어떤 것이 다른 것 없이 독립적으로 작동할 수 없고, 다른 것에게 필요한 것
    - 자동차는 연료가 있어야 움직일 수 있음, → 자동차는 연료에 의존성을 가짐
    - 식물은 물이 없으면 말라죽음 → 식물은 물에 대한 의존성을 가짐
    - 전구는 전기가 있어야 동작가능, → 전구는 전기에 대한 의존성을 가짐
    - 애플리케이션에서 DB를 사용하기 위해선 DB 드라이버에 대한 의존성을 가지게됨.
- 라이브러리 프레임워크
  - 공통점으로는 둘다 코드를 재사용할 수 있는 방법, 생산성을 제공
    - 라이브러리는 재사용 가능한 코드의 집합으로 함수, 클래스, 모듈 등 제공
    - 프레임워크 : 애플리케이션에 필요한 기본 구조, 규칙들로 구성된 틀 제공
  - 확실히 구분짓는 기준은 누가 컨트롤을 하는것인가의 차이.
    - 개발자가 컨트롤 → 라이브러리
      ex) JQuery (필요시 개발자가 호출해서 사용, 대체도 상대적으로 쉬움)
    - 정해진 규칙을 따라야함 → 프레임워크
      ex) Django (규칙을 따라서 프로그래밍을 해야만 정상적으로 동작함)
      어드민패널을 만드려면 admin.py에 반드시 작성해야 (규칙으로 정해져있음)
  - 사실 React도 본인들은 라이브러리라고 하지만 프레임워크라고 보는게 더 타당하다는 시각이 있음.

### FrontEnd 프레임워크는 왜 등장하였을까?

- 기본적으로 웹은 HTML, CSS, JavaScript로 만들어왔음
- 하지만 점차 웹기술이 발전하면서 복잡성이 증가하고, 동적인 기능, 상호작용의 필요성이 대두됨
- 기존 서버에서 모든 로직을 처리 후 전체 페이지를 띄워주는 방식 (서버의 부담) →
  클라이언트 측에서 데이터를 처리하고 업데이트하는 SPA(Single Page Application)로 패러다임이 변화됨
- 이러한 변화에 대응하기 위해서 등장한것이 FrontEnd 프레임워크(라이브러리)!
  - 개발자가 효율적으로 코드를 작성할 수 있도록 돕고, UI 상태관리, 가상 돔 같은 고급기능을 제공함으로 써 사용자 인터페이스를 편하게 개발할 수 있도록 돕는 도구
  - 여러 프레임워크가 등장했으며 대표적으로 React, Angular, Vue 가 있다.

### React, Angular, Vue

- 셋다 웹 애플리케이션 개발을 위한 JavaScript 프론트엔드 프레임워크 (라이브러리)
- 일반적으로 점유율은 React가, 접근성은 Vue가 좋다고 한다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/890a9e69-6faa-4631-9803-c2c160f9f4bb/04e27c96-4028-42fe-821e-5b10857192ff/Untitled.png)

### React

- React란?
  - 페이스북에서 개발한 자바스크립트 기반의 라이브러리
  - 웹 페이지의 각 부분을 컴포넌트로 나누어 개발하는 컴포넌트 기반 아키텍처를 따름.
    컴포넌트들은 독립적으로 동작하며, 재사용 가능.
- React의 특징
  - 가상 DOM
    - React는 가상 DOM(Virtual DOM)을 사용하여 UI를 렌더링.
      이를 통해 실제 DOM에 직접 접근하는 것보다 빠르게 화면을 업데이트.
  - 컴포넌트 기반
    - React는 UI를 재사용 가능한 개별적인 '컴포넌트'로 분리.
      코드의 재사용성이 증가하고 유지 보수가 용이해짐.
  - 단방향 데이터 흐름
    - React는 단방향 데이터 흐름 (데이터 바인딩)을 지원.
      애플리케이션 내에서 데이터가 어떻게 작동하는지 쉽게 추적하고 이해 가능.
- React의 장점, 단점
  - 장점
    - 활성화된 생태계와 큰 커뮤니티
      - React는 점유율이 압도적으로 높음, 그만큼 많은 개발자들이 있으며 커뮤니티에서 많은 정보, 도구 등을 찾아 볼 수 있음
    - 유연성
      - 다른 라이브러리나 프레임워크와 자유롭게 조합하여 사용할 수 있음
    - 성능: 가상 DOM을 활용하여 빠른 렌더링 성능을 제공
      - 데이터가 변경될 때마다 새로운 가상 DOM 트리를 생성, 이전의 가상 DOM 트리와 비교(diffing)하여 실제 변경이 필요한 부분만 찾아내고, 변경사항을 한 번에 묶어서 변경이 필요한 부분만 실제 DOM에 반영(patching)
  - 단점
    - 학습 곡선
      - JSX(JavaScriptXML) 문법, 가상DOM 등 새로운 개념들을 배워야 함
    - 프레임워크가 아니라 라이브러리라서, 복잡한 애플리케이션에서 필요한 여러 기능들을 직접 구현하거나 다른 라이브러리를 추가로 사용해야 할 수 있음.
      (ex : Redux(상태관리))
- JSX
  - HTML과 유사한 구문을 JavaScript 내에서 사용할 수 있게 해주는 문법
  ```jsx
  class MyComponent extends React.Component {
    render() {
      let name = "World";
      return (
        <div>
          <h1>Hello {name}</h1> // Hello World 출력.
        </div>
      );
    }
  }
  ```
- Styled Component

  - CSS-in-JS 스타일링을 가능하게 하는 라이브러리. JavaScript 파일 내부에 CSS를 작성할 수 있으며, 보다 직관적으로 관리할 수 있게 해줌.
  - 컴포넌트 단위의 스타일링으로 각 컴포넌트에 대한 스타일을 해당 컴포넌트 내에서 정의할 수 있으며, 스타일과 컴포넌트 로직이 분리되지 않고 한 곳에서 관리될 수 있어 유지 보수가 쉽다.

  ```jsx
  import styled from 'styled-components';

  <Button primary>Primary Button</Button>
  <Button>Default Button</Button>

  // 사용예시
  const 컴포넌트이름 = styled.태그명`CSS속성`;

  const Button = styled.button`
    background: ${props => props.primary ? 'palevioletred' : 'white'};
    color: ${props => props.primary ? 'white' : 'palevioletred'};
  `;
  ```

### Angular

- Angular란?
  - 구글에서 개발, 유지관리하는 오픈소스 웹 애플리케이션 프레임워크
- Angular의 특징
  - TypeScript
    - 자유분방한 JavaScript의 슈퍼셋인 정적 타입 검사가 있는 TypeScript를 기본언어로 사용
    - 높은 수준의 코드 안전성, 개발 생산성을 제공
  - 강력한 모듈 시스템
    - Angular에서 각각의 기능은 모듈로 나뉘며, 각각의 모듈들은 서로 의존관계를 가지거나 다른 프로젝트에서 재사용 가능
  - 양방향 데이터 바인딩
    - 모델, View사이에서 자동으로 데이터를 동기화해주는 양방향 데이터 바인딩을 지원
  - 강력한 라우팅, 상태관리
    - 라우팅, 상태관리 기능들이 기본적으로 내장 돼있어 SPA의 네비게이션, 상태관리를 용이케 함
- Angular의 장단점

  - 장점
    - 강력한 프레임워크
      - 완전한 프레임워크로 많은 내장 기능들이 함께 제공
      - 큰 규모의 애플리케이션 개발시 많이 사용
    - 생태계 및 지원
      - Google에서 관리하고 있으며, 큰 커뮤니티가 형성돼있음
  - 단점
    - TypeScript 기반의 언어이기 때문에 JavaScript대비 학습량이 증가
    - Angular자체의 복잡성 때문에 학습량이 증가
    - 초기 설정이 복잡함

- Angulard의 예시코드

```html
//hello-world.component.ts import { Component } from '@angular/core';
@Component({ selector: 'app-hello-world', template: `
<h1>Hello, {{ name }}!</h1>
<button (click)="changeName()">Change Name</button>
`, }) export class HelloWorldComponent { name = 'Angular'; changeName() {
this.name = 'World'; } } //app.component.html

<h2>Welcome to {{ title }}!</h2>
<app-hello-world></app-hello-world>

//app.component.ts import { Component } from '@angular/core'; @Component({
selector: 'app-root', templateUrl: './app.component.html', }) export class
AppComponent { title = 'My App'; }
```

- 1~5까지 더하는 앵귤러 페이지

```html
app.component.ts import { Component } from '@angular/core'; @Component({
selector: 'app-root', templateUrl: './app.component.html', }) export class
AppComponent { sum: number; constructor() { this.sum = this.calculateSum(1, 5);
} calculateSum(start: number, end: number): number { let sum = 0; for (let i =
start; i <= end; i++) { sum += i; } return sum; } } app.component.html

<h2>Sum Calculation</h2>
<p>The sum of numbers from 1 to 5 is {{ sum }}</p>
```

### Vue

- Vue란?
  - 사용자 인터페이스를 구축하기 위한 자바스크립트 프레임워크
- Vue의 특징
  - 간결하고 직관적인 문법
    - 기본적인 문법들이 HTML과 유사하기 때문에 학습곡선이 낮고 쉽게 접근이가능
  - 단일 파일 컴포넌트
    - 각 컴포너트는 .vue 확장자로 작성되며, HTML, JS, CSS 스타일을 한파일에 모아 관리 가능
  - 유연성 (progressive)
    - 개발을 점진적으로 구축, 확장 할 수 있는 특성
    - 다른 라이브러리, 프레임워크와 함께 사용 가능
    - ex) jQuery, React의 일부 기능과 함께 사용 가능
  - 모듈화
    - 애플리케이션 구축을 위한 모듈화된 아키텍쳐를 지원
- Vue의 장점과 단점

  - 장점
    - 학습 곡선이 낮음
      - 직관적인 문법과 단순한 API로 인해 학습하기 쉬움
    - 유연하고 확장 가능함
      - 필요에 따라 작은 규모부터 대규모 애플리케이션까지 구축할 수 있는 유연성과 확장 가능성.
    - 성능
      - 가상 DOM 및 최적화된 랜더링 알고리즘 등으로 인해 뛰어난 성능을 제공
  - 단점
    - 큰 규모의 애플리케이션에서 관리 복잡도 증가 가능
      - 상태 관리와 모듈화 등 복잡한 기능들은 추가적인 라이브러리(Vuex 등)를 사용하여 처리해야 할 수도 있음
    - 생태계 크기와 지원 범위
      - React나 Angular에 비해 커뮤니티가 상대적으로 작음, 지원되는 모듈과 도구들도 그만큼 많지 않을 수 있음.

- Vue 코드 미리보기
  <template> 에는 HTML을 작성
    <script>에는 JavaScript로직 정의
    
    <style> 스타일 지정 
    
    - 위와같이 3가지 파트로 나누어 한 파일에 작성
    
    ### 기본적인 Vue 코드
    
    ```html
    <template>
      <div>
        <h1>{{ message }}</h1>
        <button @click="increment">Increment</button>
      </div>
    </template>
    
    <script>
    export default {
      data() {
        return {
          message: 'Hello Vue!',
          count: 0
        };
      },
      methods: {
        increment() {
          this.count++;
        }
      }
    };
    </script>
    <style scoped>
    h1 {
      color: blue;
    }
    </style>

  ```

  ```

- React with Vue

```html
import React from 'react'; import ReactDOM from 'react-dom'; import App from
'./App.vue'; // Vue.js 컴포넌트를 import function MyReactComponent() { return (
<div>
  <h1>Hello React!</h1>
  <App /> {/* Vue.js 컴포넌트를 JSX 문법으로 사용가능 */}
</div>
); } ReactDOM.render(<MyReactComponent />, document.getElementById('root'));
```

- vue-styled-components
  - vue.js 컴포넌트에 CSS-in-JS스타일링을 적용할수있게 해줌

```html
<template>
  <StyledButton primary>{{ buttonText }}</StyledButton>
</template>

<script>
  import styled from "vue-styled-components";

  // 스타일드 컴포넌트 정의
  const StyledButton = styled.button`
    background: ${(props) => (props.primary ? "palevioletred" : "white")};
    color: ${(props) => (props.primary ? "white" : "palevioletred")};
    padding: 8px 16px;
    border-radius: 4px;
  `;

  export default {
    data() {
      return {
        buttonText: "Click me!",
      };
    },
  };
</script>
```
