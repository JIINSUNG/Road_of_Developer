<script setup>
import { provide, readonly, reactive } from 'vue'
import TheHeadingNavbar from '@/components/layout/TheHeadingNavbar.vue'
import TheBookView from './views/TheBookView.vue'

// 화면 전환을 위한 상태값 선언
const stateControll = reactive({
  LIST: 1,
  DETAIL: 2,
  REGIST: 3
})

// 모든 컴포넌트에서 사용할 수 있도록 provide로 등록
provide('state', readonly(stateControll))
</script>

<template>
  <TheHeadingNavbar />
  <TheBookView />
</template>

<style scoped></style>
