<script setup>
import { ref, inject } from 'vue'
import { useRouter } from 'vue-router'
import { registBook } from '@/api/book'

const router = useRouter()
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

const books = inject('books')
console.log('books............', books)

// 등록시 생성한 Book 객체를 저장할 반응형 변수

// let bookSt = localStorage.getItem('books')
// if (bookSt) {
//   books.value = JSON.parse(bookSt).books
// }

localStorage.getItem('books') && (books.value = JSON.parse(localStorage.getItem('books')).books)

function moveHandler() {
  console.log('moveHandler............')
  // $emit을 통해 부모 컴포넌트에게 이벤트를 전달
  // $emit('이벤트명', 전달할 데이터)
  router.push({ name: 'book-list' })
}

function createHandler() {
  let err = true
  let msg = ''

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
    registBook(
      {
        isbn: isbn.value,
        title: title.value,
        author: author.value,
        price: price.value,
        describ: describ.value
      },
      ({ data }) => {
        console.log('등록 완료!!', data)
        alert('등록완료')
        moveHandler()
      },
      (error) => {
        console.log(error)
        alert('등록실패')
      }
    )
    title.value = ''
    isbn.value = ''
    author.value = ''
    price.value = ''
    describ.value = ''
  }
}
</script>

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
            <button class="btn btn-primary m-1" @click="createHandler">등록</button>
            <button class="btn btn-primary m-1" @click="moveHandler">목록</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped></style>
