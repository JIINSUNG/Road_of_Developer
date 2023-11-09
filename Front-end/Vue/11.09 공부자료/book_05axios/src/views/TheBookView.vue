<script setup>
import { ref, provide, watch } from 'vue'

// 초기 화면은 LIST 화면으로 표시

//List에서 선택한 isbn을 전달받아서 Detail화면에 전달할 예정

const books = ref([])
let bookSt = localStorage.getItem('books')
if (bookSt) {
  books.value = JSON.parse(bookSt).books
}

provide('books', books)

watch(books, updateBooks, { deep: true })

function updateBooks() {
  console.log('watch..........updateBooks :', books.value)
  localStorage.setItem('books', JSON.stringify({ books: books.value }))
}
</script>

<template>
  <div class="text-center m-4">
    <div class="alert alert-info" role="alert">도서 정보</div>
    <RouterView />
  </div>
</template>

<style scoped></style>
