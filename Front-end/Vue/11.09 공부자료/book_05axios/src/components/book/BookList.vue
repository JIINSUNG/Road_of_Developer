<script setup>
import { ref, reactive } from 'vue'
import { listBook } from '@/api/book'
import BookListItem from './item/BookListItem.vue'
import VSelect from '@/components/common/VSelect.vue'
import PageNavigation from '@/components/common/pagenavigation.vue'
import { useRouter } from 'vue-router'

// 목록에 표시할 books를 반응현으로 선언
const books = ref([])

//서버에 보낼 조회 조건을 위한 반응형 변수 선언
const params = reactive({
  pageNo: 1,
  key: 'all',
  word: ''
})

//PageNavigation을 위한 반응형 변수
const currentPage = ref(1)
const totalPage = ref(1)

const router = useRouter()

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

function searchList() {
  console.log('BookList.searchList..... params', params)
  listBook(
    params,
    ({ data }) => {
      console.log('search......result:', data)
      books.value = data.books
      currentPage.value = data.page.pageNo
      totalPage.value = data.page.total
    },
    (error) => {
      console.log(error)
      alert('문제발생!')
    }
  )
}
console.log('BookList.setup...........')
searchList()

const changeKey = (val) => {
  console.log('BookList.search.........changeKey:', val)
  params.key = val
}

function moveHandler() {
  router.push({ name: 'book-regist' })
}

function onPageChange(value) {
  console.log('BookList.onPageChange.......pageNo:', value)
  params.pageNo = value
  searchList()
}
</script>

<template>
  <h3 class="text-center">등록된 도서 목록</h3>
  <div class="row">
    <div class="col-6">
      <!-- <RouterLink class="btn btn-outline-primary" to="/book/regist">등록</RouterLink> -->
      <button class="btn btn-outline-primary" @click="moveHandler">등록</button>
    </div>
    <div class="col-6">
      <div class="input-group">
        <span class="input-group-text">검색조건</span>
        <VSelect :select-options="selectOptions" @onKeySelect="changeKey" />
        <input
          type="text"
          class="input-control"
          placeholder="검색어를 입력하세요"
          v-model="params.word"
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
        <BookListItem v-for="book in books" :key="book.isbn" :book="book"></BookListItem>
      </tbody>
    </table>
  </div>
  <div v-else>
    <h3>등록된 책 정보가 없습니다.</h3>
  </div>
  <PageNavigation
    :currentPage="currentPage"
    :total-page="totalPage"
    @page-change="onPageChange"
  ></PageNavigation>
</template>

<style scoped></style>
