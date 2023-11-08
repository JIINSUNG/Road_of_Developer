<script setup>
import { inject, ref } from 'vue'
import BookListItem from './item/BookListItem.vue'
import VSelect from '../common/VSelect.vue'
import PageNavigation from '../common/pagenavigation.vue'
const { REGIST, DETAIL } = inject('state')
// 목록에 표시할 book을 반응현 변수로 선언
const books = inject('books')

//검색 조건을 위한 변수 선언
const key = ref('all')
const word = ref('')

// VSelect 컴포넌트의 props
const selectOptions = ref([
  { text: '선택하세요', value: 'all' },
  { text: '제목', value: 'title' },
  { text: '저자', value: 'author' }
])

// 검색한 내용을 모록에 표시하기 위한 변수
// 초기에는 books와 값이 같다.
// 주의점 const searchBooks = books로 하면 검색조건에 따라 데이터가 변경될 때
// 원본데이터도 변경될 수 있음, 그래서 ref로 선언
const searchBooks = ref(books.value) // 검색한 결과를 저장할 변수

function searchList() {
  console.log('BookList.searchList..... key:', key.value, 'word:', word.value)
  if (key.value == 'all' || word.value == '') {
    searchBooks.value = books.value
  } else if (key.value == 'title') {
    searchBooks.value = books.value.filter((book) => {
      if (book.title.includes(word.value)) return book
    })
  } else {
    searchBooks.value = books.value.filter((book) => {
      if (book.author.includes(word.value)) return book
    })
  }
  console.log('search.........', searchBooks.value)
}

const changeKey = (val) => {
  console.log('BookList.search.........changeKey:', val)
  key.value = val
}
</script>

<template>
  <h3 class="text-center">등록된 도서 목록</h3>
  <div class="row">
    <div class="col-6">
      <button class="btn btn-outline-primary" @click="$emit('changeState', REGIST)">등록</button>
    </div>
    <div class="col-6">
      <div class="input-group">
        <span class="input-group-text">검색조건</span>
        <VSelect :select-options="selectOptions" @onKeySelect="changeKey" />
        <input
          type="text"
          class="input-control"
          placeholder="검색어를 입력하세요"
          v-model="word"
          @keyup.enter="searchList"
        />
        <button class="btn btn-dark" @click="searchList">검색</button>
      </div>
    </div>
  </div>
  <div v-if="books.length > 0">
    <table class="table table-boardered table-hover">
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
        </tr>
      </thead>
      <tbody>
        <BookListItem
          v-for="book in searchBooks"
          :key="book.isbn"
          :book="book"
          @click="$emit('changeState', DETAIL, book)"
        ></BookListItem>
      </tbody>
    </table>
  </div>
  <div v-else>
    <h3>등록된 책 정보가 없습니다.</h3>
  </div>
  <PageNavigation></PageNavigation>
</template>

<style scoped></style>
