<!-- Component의 기능(JS) -->
<!-- CLI환경에선 기본적으로 return을 해주기 때문에 return을 명시해줄 필요가 없다.-->
<!-- 만약 특정한 변수들만 리턴하고 싶다면 setup 메서드를 직접적으로 구현해줘야함 -->
<script setup>
import { ref, watch } from 'vue'

/* v-model과 연결할 반응형 변수 선언, setup에서는 DOM tree가 구성되지 않았기 때문에 Dom에 접근할 수 없다.
   mounted 이후에 접근이 가능하다.

*/
const isbn = ref('')
const title = ref('')
const author = ref('')
const price = ref('')
const describ = ref('')

// Dom과 연결할 반응형 변수 선언
const isbnDiv = ref(null)
const titleDiv = ref(null)
const authorDiv = ref(null)

// 등록시 생성한 Book 객체를 저장할 반응형 변수
const books = ref([])

// let bookSt = localStorage.getItem('books')
// if (bookSt) {
//   books.value = JSON.parse(bookSt).books
// }

localStorage.getItem('books') && (books.value = JSON.parse(localStorage.getItem('books')).books)

function createHandler() {
  let err = true
  let msg = ''

  // if (!isbn.value) {
  //   msg = '책 일련번호를 입력하세요.'
  //   err = false
  //   isbnDiv.value.focus()
  // }else if(err && !title.value){}

  !isbn.value && ((msg = '책 일련 번호를 입력해 주세요'), (err = false), isbnDiv.value.focus())
  err && !title.value && ((msg = '제목을 입력해 주세요'), (err = false), titleDiv.value.focus())
  err && !author.value && ((msg = '저자를 입력해 주세요'), (err = false), authorDiv.value.focus())

  // v-show -> 조건이 만족되지 않는다면 display none 처리, else if 같은 조건이 없음
  // v-if -> 조건이 만족되지 않는다면 주석 처리, else if와 같은 조건들도 있음.
  // v-for -> 반복문, v-for="item in items" :key="item.id" -> item은 items의 요소들을 순차적으로 가리킴
  // key는 고유한 값이어야함, v-for는 반복문이기 때문에 key를 통해 구분해줘야함
  if (!err) {
    alert(msg)
  } else {
    books.value.push({
      isbn: isbn.value,
      title: title.value,
      author: author.value,
      price: price.value,
      describ: describ.value
    })
    console.log(books.value)
    title.value = ''
    isbn.value = ''
    author.value = ''
    price.value = ''
    describ.value = ''
    alert('등록')
  }
}

watch(books, updateBooks, { deep: true })
function updateBooks() {
  console.log('watch..........updateBooks :', books.value)
  localStorage.setItem('books', JSON.stringify({ books: books.value }))
}
</script>

<!-- Component UI(HTML) -->

<template>
  <div class="me-4">
    <h1 class="underline text-center">도서 등록</h1>
    <table class="table table-boardered">
      <thead>
        <tr>
          <td>책 일련 번호</td>
          <!-- Vue객체에서 Dom에 접근 -->
          <td><input type="text" ref="isbnDiv" v-model="isbn" /></td>
        </tr>
        <tr>
          <td>제목</td>
          <!-- Vue객체에서 Dom에 접근 -->
          <td><input type="text" ref="titleDiv" v-model="title" /></td>
        </tr>
        <tr>
          <td>저자</td>
          <!-- Vue객체에서 Dom에 접근 -->
          <td><input type="text" ref="authorDiv" v-model="author" /></td>
        </tr>
        <tr>
          <td>가격</td>
          <!-- Vue객체에서 Dom에 접근 -->
          <td><input type="text" v-model="price" /></td>
        </tr>
        <tr>
          <td colspan="2">책 정보</td>
        </tr>
        <tr>
          <td colspan="2"><textarea v-model="describ" cols="45" rows="10" /></td>
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
  <div v-if="books.length > 0">
    <h3 class="underline text-center">등록된 도서 목록</h3>
    <table class="table table-hover">
      <thead>
        <colgroup>
          <col width="25%" />
          <col width="40%" />
          <col width="15%" />
          <col width="20%" />
        </colgroup>
        <tr>
          <th>책 일련 번호</th>
          <th>제목</th>
          <th>저자</th>
          <th>가격</th>
          <th>정보</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="book in books" :key="book.isbn">
          <td>{{ book.isbn }}</td>
          <td>{{ book.title }}</td>
          <td v-text="book.author"></td>
          <td v-text="book.price"></td>
          <td v-text="book.describ"></td>
        </tr>
      </tbody>
    </table>
  </div>
  <div v-else>
    <h3>등록된 책 정보가 없습니다.</h3>
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
