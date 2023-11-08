<script setup>
import { inject, ref } from 'vue'
import PageNavigation from '../../../../boardHW-vue/src/components/common/PageNavigation.vue'
import BoardListItem from '@/components/board/item/BoardListItem.vue'
import VSelect from '../common/VSelect.vue'
const { WRITE, DETAIL } = inject('state')
const boards = inject('boards')

// VSelect 컴포넌트의 props
const selectOptions = ref([
  { text: '선택하세요', value: '' },
  { text: '전체', value: 'all' },
  { text: '제목', value: 'subject' },
  { text: '글쓴이', value: 'userId' }
])

const key = ref('all')
const word = ref('')

const searchBoards = ref(boards.value) // 검색한 결과를 저장할 변수

function searchList() {
  console.log('BookList.searchList..... key:', key.value, 'word:', word.value)
  if (key.value == 'all' || word.value == '') {
    searchBoards.value = boards.value
  } else if (key.value == 'subject') {
    searchBoards.value = boards.value.filter((article) => {
      if (article.subject.includes(word.value)) return article
    })
  } else {
    searchBoards.value = boards.value.filter((article) => {
      if (article.userId.includes(word.value)) return article
    })
  }
  console.log('search.........', searchBoards.value)
}

const changeKey = (val) => {
  console.log('BookList.search.........changeKey:', val)
  key.value = val
}
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
          <mark class="sky">글목록</mark>
        </h2>
      </div>
      <div class="col-lg-10">
        <div class="row align-self-center mb-2">
          <div class="col-md-2 text-start">
            <button
              type="button"
              id="btn-mv-register"
              class="btn btn-outline-primary btn-sm"
              @click="$emit('changeState', WRITE)"
            >
              글쓰기
            </button>
          </div>
          <div class="col-md-5 offset-5">
            <form class="d-flex">
              <VSelect :select-options="selectOptions" @on-key-select="changeKey" />
              <div class="input-group input-group-sm">
                <input
                  type="text"
                  class="form-control"
                  placeholder="검색어..."
                  v-model="word"
                  @keydown.enter.prevent="searchList"
                />
                <button class="btn btn-dark" type="button" @click="searchList">검색</button>
              </div>
            </form>
          </div>
        </div>
        <table class="table table-hover">
          <thead>
            <tr class="text-center">
              <th scope="col">글번호</th>
              <th scope="col">제목</th>
              <th scope="col">작성자</th>
              <th scope="col">조회수</th>
              <th scope="col">작성일</th>
            </tr>
          </thead>
          <tbody>
            <BoardListItem
              v-for="article in searchBoards"
              :key="article.articleNo"
              :article="article"
              @click="$emit('changeState', DETAIL, article)"
            />
          </tbody>
        </table>
        <PageNavigation />
      </div>
    </div>
  </div>
</template>

<style scoped></style>
