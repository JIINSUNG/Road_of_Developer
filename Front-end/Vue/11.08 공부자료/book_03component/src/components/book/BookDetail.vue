<script setup>
import { ref, inject } from 'vue'

const { LIST } = inject('state')
const emit = defineEmits(['changeState'])

const props = defineProps({
  book: Object
})

const books = inject('books')

const book = ref(props.book)

// 초기에는 Detail화면 표시하기 위해 readonly = 'readonly'로 표시
// 수정버튼을 누르면 readonly = ''로 변경
const isReadonly = ref(true)

function removeHandler() {
  console.log('BookDetail.remove...............')
  books.value = books.value.filter((item) => item.isbn != props.book.isbn)
  console.log('BookDetail.remove...............', books.value)
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
          <th>ISBN</th>
          <td><input type="text" v-model.lazy="book.isbn" readonly="readonly" /></td>
        </tr>
        <tr>
          <th>제목</th>
          <td><input type="text" v-model.lazy="book.title" :readonly="isReadonly" /></td>
        </tr>
        <tr>
          <th>저자</th>
          <td><input type="text" v-model.lazy="book.author" :readonly="isReadonly" /></td>
        </tr>
        <tr>
          <th>가격</th>
          <td><input type="text" v-model.lazy="book.price" :readonly="isReadonly" /></td>
        </tr>

        <tr>
          <th colspan="2">책 정보</th>
        </tr>
        <tr>
          <td colsapn="2">
            <textarea
              cols="45"
              rows="10"
              v-model.lazy="book.describ"
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
