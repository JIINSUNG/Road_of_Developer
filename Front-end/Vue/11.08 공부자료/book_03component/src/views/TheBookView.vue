<script setup>
import { inject, ref, provide, watch } from 'vue'

import BookList from '../components/book/BookList.vue'
import BookRegist from '../components/book/BookRegist.vue'
import BookDetail from '../components/book/item/BookDetail.vue'

// inject받은 state 객체(reactive)를 사용하기 위해 비구조화 할당
// reactive라 .value할 필요없지만, 만약 ref로 왔다면 .value를 해줘야함
const { LIST, REGIST, DETAIL } = inject('state')

// 초기 화면은 LIST 화면으로 표시
let state = ref(LIST)

//List에서 선택한 isbn을 전달받아서 Detail화면에 전달할 예정
// const isbn = ref(0)

const books = ref([])
let bookSt = localStorage.getItem('books')
if (bookSt) {
  books.value = JSON.parse(bookSt).books
}

provide('books', books)

//BookList에서 전달한 Book정보를 BookDetail에서 props로 전달하기 위한 변수
const book = ref(null)

watch(books, updateBooks, { deep: true })
function updateBooks() {
  console.log('watch..........updateBooks :', books.value)
  localStorage.setItem('books', JSON.stringify({ books: books.value }))
}

function changeState(s, i) {
  console.log('state.value............', state.value)
  state.value = s // 화면 상태를 변경한다
  if (s == DETAIL) {
    console.log('changeState............')
    book.value = i
  }
}
</script>

<template>
  <div v-if="state == LIST">
    <BookList @change-state="changeState" />
  </div>
  <div v-else-if="state == REGIST">
    <BookRegist @change-state="changeState" />
  </div>
  <div v-else-if="state == DETAIL">
    <BookDetail @change-state="changeState" :book="book" />
  </div>
</template>

<style scoped></style>
