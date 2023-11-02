<!-- Component의 기능(JS) -->
<!-- CLI환경에선 기본적으로 return을 해주기 때문에 return을 명시해줄 필요가 없다.-->
<!-- 만약 특정한 변수들만 리턴하고 싶다면 setup 메서드를 직접적으로 구현해줘야함 -->
<script setup>
import { ref } from 'vue'

/* v-model과 연결할 반응형 변수 선언, setup에서는 DOM tree가 구성되지 않았기 때문에 Dom에 접근할 수 없다.
   mounted 이후에 접근이 가능하다.

*/
const index = ref('')
const writer = ref('')
const title = ref('')
const content = ref('')

// Dom과 연결할 반응형 변수 선언
const writerDiv = ref(null)
const titleDiv = ref(null)
const contentDiv = ref(null)

// 등록시 생성한 article 객체를 저장할 반응형 변수
const articles = ref([])

let articleST = localStorage.getItem('articles')
//localstroage에 있는 articles의 마지막 요소의 데이터를 가져와 그 인덱스 +1을 해주는 코드를 작성해줘

if (articleST) {
  index.value = JSON.parse(articleST).articles[JSON.parse(articleST).articles.length - 1].index + 1
} else {
  index.value = 1
}

if (articleST) {
  articles.value = JSON.parse(articleST).articles
}

function createHandler() {
  let err = true
  let msg = ''

  !writer.value && ((msg = '작성자를 입력해 주세요'), (err = false), writerDiv.value.focus())
  err && !title.value && ((msg = '제목을 입력해 주세요'), (err = false), titleDiv.value.focus())
  err && !content.value && ((msg = '내용을 입력해 주세요'), (err = false), contentDiv.value.focus())

  // v-show -> 조건이 만족되지 않는다면 display none 처리, else if 같은 조건이 없음
  // v-if -> 조건이 만족되지 않는다면 주석 처리, else if와 같은 조건들도 있음.
  // v-for -> 반복문, v-for="item in items" :key="item.id" -> item은 items의 요소들을 순차적으로 가리킴
  // key는 고유한 값이어야함, v-for는 반복문이기 때문에 key를 통해 구분해줘야함

  if (!err) {
    alert(msg)
  } else {
    articles.value.push({
      index: index.value,
      writer: writer.value,
      title: title.value,
      content: content.value
    })

    console.log(articles.value)

    const articleSt = localStorage.getItem('articles')
    let newArticles = {
      articles: []
    }
    if (articleSt) {
      newArticles = JSON.parse(articleSt)
    }
    newArticles.articles.push({
      index: index.value++,
      writer: writer.value,
      title: title.value,
      content: content.value
    })
    localStorage.setItem('articles', JSON.stringify(newArticles))
  }
}
</script>

<!-- Component UI(HTML) -->

<template>
  <div class="me-4">
    <h1 class="underline text-center highlight">SSAFY 글 등록</h1>
    <table class="table table-boardered">
      <thead>
        <tr>
          <td>작성자</td>
          <!-- Vue객체에서 Dom에 접근 -->
          <td><input type="text" ref="writerDiv" v-model="writer" /></td>
        </tr>
        <tr>
          <td>제목</td>
          <!-- Vue객체에서 Dom에 접근 -->
          <td><input type="text" ref="titleDiv" v-model="title" /></td>
        </tr>
        <tr>
          <td>내용</td>
          <!-- Vue객체에서 Dom에 접근 -->
          <td><textarea cols="50" area="45" type="text" ref="contentDiv" v-model="content" /></td>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td colspan="2" class="text-center">
            <button class="btn btn-primary" @click="createHandler">등록</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  <div v-if="articles.length > 0">
    <h3 class="underline text-center">SSAFY 글 목록</h3>
    <table class="table table-hover">
      <thead>
        <colgroup>
          <col width="10%" />
          <col width="45%" />
          <col width="45%" />
        </colgroup>
        <tr>
          <th>글 번호</th>
          <th>제목</th>
          <th>작성자</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="article in articles" :key="article.index">
          <td v-text="article.index"></td>
          <td v-text="article.title"></td>
          <td v-text="article.writer"></td>
        </tr>
      </tbody>
    </table>
  </div>
  <div v-else>
    <h3>등록된 글 정보가 없습니다.</h3>
  </div>
</template>

<!-- Component UI(CSS), 지역적(현재 파일에 있는 요소들에만 영향) -->
<style scoped>
header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  nav {
    text-align: left;
    margin-left: -1rem;
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}
</style>
