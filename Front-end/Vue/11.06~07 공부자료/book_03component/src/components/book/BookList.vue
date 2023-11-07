<script setup>
import { inject } from 'vue'
const { REGIST } = inject('state')
const books = inject('books')
</script>

<template>
  <h3 class="underline text-center">등록된 도서 목록</h3>
  <div class="clear-fix">
    <button class="btn btn-primary float-end" @click="$emit('changeState', REGIST)">등록</button>
  </div>
  <div v-if="books.length > 0">
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

<style scoped></style>
