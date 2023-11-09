<script setup>
import { ref } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { detailBook, updateBook, removeBook } from '@/api/book'

/////// router로 이동시 전달한 데이터를 전달받기 위해
const route = useRoute()

/////// router로 화면 이동하기 위해
const router = useRouter()

// :to={name:'', query:{}} 로 전달한 데이터를 받기 위해
const isbn = ref(route.query.isbn)

// dom이 마운트된 상태에서 아직 서버에서 데이터가 안온 경우
// book의 데이터를 화면에 표시 할 수 없어서 error가 발생하므로 초기 설정
const book = ref({
  isbn: '',
  title: '',
  author: '',
  price: '',
  describ: ''
})
console.log('BookDetail.setup........ 데이터 불러오기')
detailBook(
  isbn.value,
  ({ data }) => {
    console.log('BookDetail.setup........ 데이터 전송 완료!! book:', data)
    book.value = data
  },
  (error) => {
    console.log(error)
  }
)

// 초기에는 Detail화면 표시하기 위해 readonly = 'readonly'로 표시
// 수정버튼을 누르면 readonly = ''로 변경
const isReadonly = ref(true)

function removeHandler() {
  console.log('BookDetail.remove...............')
  removeBook(
    isbn.value,
    ({ data }) => {
      console.log('BookDetail.remove...............삭제 완료!! result:', data)
      alert('삭제 성공')
      moveHandler()
    },
    (error) => {
      console.log(error)
      alert('삭제 실패')
    }
  )
}

function moveHandler() {
  // 프로그램 방식으로  router 이동
  router.push({ name: 'book-list' })
}

function updateHandler() {
  if (!isReadonly.value) {
    // update화면에서 데이터 수정 후 update 요청
    console.log('BookDetail.update...............수정!!')
    updateBook(
      book.value,
      ({ data }) => {
        console.log('BookDetail.update...............result :', data)
        alert('수정 성공')
        moveHandler()
      },
      (error) => {
        console.log(error)
        alert('수정 실패')
      }
    )
  }
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
          <td colspan="2">
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
