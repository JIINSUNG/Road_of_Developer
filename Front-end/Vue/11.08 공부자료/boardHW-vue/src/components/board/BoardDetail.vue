<script setup>
import { ref, inject } from 'vue'

const { LIST } = inject('state')
const emit = defineEmits(['changeState'])

const props = defineProps({
  article: Object
})

const boards = inject('boards')

const article = ref(props.article)
article.value.hit++

// 초기에는 Detail화면 표시하기 위해 readonly = 'readonly'로 표시
// 수정버튼을 누르면 readonly = ''로 변경
const isReadonly = ref(true)

function removeHandler() {
  console.log('BoardDetail.remove...............')
  boards.value = boards.value.filter((item) => item.articleNo != props.article.articleNo)
  console.log('BookDetail.remove...............', boards.value)
  moveHandler()
}

function moveHandler() {
  console.log('BookDetail.moveHandler............')
  emit('changeState', LIST)
}

function updateHandler() {
  // books에 있는 book객체를 props로 전달 받았고, props도 반응형이라서
  // v-model로 props 데이터를 변경하면 books에 바로 반영된다.
  // 그래서 화면 전환만 하면 된다.
  isReadonly.value = !isReadonly.value
}
</script>

<template>
  <div>
    <table class="table table-bordered">
      <tbody>
        <tr>
          <th>글번호</th>
          <td><input type="text" v-model.lazy="article.articleNo" readonly="readonly" /></td>
        </tr>
        <tr>
          <th>작성자</th>
          <td><input type="text" v-model.lazy="article.userId" readonly="readonly" /></td>
        </tr>
        <tr>
          <th>제목</th>
          <td><input type="text" v-model.lazy="article.subject" :readonly="isReadonly" /></td>
        </tr>
        <tr class="text-center">
          <th colspan="2">내용</th>
        </tr>
        <tr class="text-center">
          <td colspan="2">
            <textarea
              class="text-center border-0"
              cols="45"
              rows="10"
              v-model.lazy="article.content"
              :readonly="isReadonly"
            ></textarea>
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <button class="btn btn-outline-primary m-1" @click="updateHandler">수정</button>
            <button class="btn btn-outline-primary m-1" @click="moveHandler">목록</button>
            <button class="btn btn-outline-primary m-1" @click="removeHandler">삭제</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>
input:read-only {
  background-color: lightgray;
}
</style>
