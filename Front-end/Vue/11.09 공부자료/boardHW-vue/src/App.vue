<script setup>
import { reactive, provide, readonly } from 'vue'
import TheHeadingNavbar from './components/layout/TheHeadingNavbar.vue'
import BoardView from './views/BoardView.vue'

// 화면 전환을 위한 상태값 선언
const stateControll = reactive({
  LIST: 1, // 글목록 출력뷰
  WRITE: 2, // 글작성 출력뷰
  DETAIL: 3 // 글상세 조회뷰
})

// 모든 컴포넌트에서 사용할 수 있도록 provide로 등록
provide('state', readonly(stateControll))
</script>

<template>
  <div>
    <TheHeadingNavbar />
    <BoardView />
  </div>
</template>

<style scoped></style>
