<script setup>
import { inject, ref, provide, watch } from 'vue'

import BoardList from '@/components/board/BoardList.vue'
import BoardWrite from '@/components/board/BoardWrite.vue'
import BoardDetail from '@/components/board/BoardDetail.vue'

const { LIST, WRITE, DETAIL } = inject('state')

let state = ref(LIST)

// list에서 선택한 article의 번호를 전달받아 Detail에 전달할 예정
// const articleNo = ref(0)

const boards = ref([])
const article = ref(null)
let boardsSt = localStorage.getItem('boards')

if (boardsSt) {
  boards.value = JSON.parse(boardsSt).boards
}

provide('boards', boards)

watch(boards, updateArticles, { deep: true })

function updateArticles() {
  console.log('watch..........updateArticles :', boards.value)
  localStorage.setItem('boards', JSON.stringify({ boards: boards.value }))
}

function changeState(s, i) {
  console.log('state.value............', state.value)
  state.value = s
  if (s == DETAIL) {
    console.log('changeState............')
    article.value = i
  }
}
</script>

<template>
  <div v-if="state == LIST">
    <BoardList @change-state="changeState" />
  </div>
  <div v-if="state == WRITE">
    <BoardWrite @change-state="changeState" />
  </div>
  <div v-if="state == DETAIL">
    <BoardDetail @change-state="changeState" :article="article" />
  </div>
</template>

<style scoped></style>
