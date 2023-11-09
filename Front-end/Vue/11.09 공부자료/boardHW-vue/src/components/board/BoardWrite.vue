<script setup>
import { ref, inject } from 'vue'

const emit = defineEmits(['changeState'])

const articleNo = ref('')
const subject = ref('')
const userId = ref('')
const content = ref('')

const subjectDiv = ref(null)
const userIdDiv = ref(null)
const contentDiv = ref(null)
const boards = inject('boards')
localStorage.getItem('boards') && (boards.value = JSON.parse(localStorage.getItem('boards')).boards)

const { LIST } = inject('state')

//localstorage에서 boards를 가져온후 가장 마지막 인덱스의 값을 저장하고 싶어

let index = 1
if (localStorage.getItem('boards')) {
  const parsedBoards = JSON.parse(localStorage.getItem('boards')).boards
  if (parsedBoards.length > 0) {
    index = parsedBoards[parsedBoards.length - 1].articleNo + 1
  }
}
function makeDate() {
  let today = new Date()
  var year = today.getFullYear()
  var month = ('0' + (today.getMonth() + 1)).slice(-2)
  var day = ('0' + today.getDate()).slice(-2)
  var dateString = year + '년' + month + '월' + day + '일'
  return dateString
}

function createHandler() {
  let err = true
  let msg = ''

  !subject.value && ((msg = '글의 제목을 입력해 주세요'), (err = false), subjectDiv.value.focus())
  err && !userId.value && ((msg = '작성자를 입력해 주세요'), (err = false), userIdDiv.value.focus())
  err && !content.value && ((msg = '내용을 입력해 주세요'), (err = false), contentDiv.value.focus())

  // v-show -> 조건이 만족되지 않는다면 display none 처리, else if 같은 조건이 없음
  // v-if -> 조건이 만족되지 않는다면 주석 처리, else if와 같은 조건들도 있음.
  // v-for -> 반복문, v-for="item in items" :key="item.id" -> item은 items의 요소들을 순차적으로 가리킴
  // key는 고유한 값이어야함, v-for는 반복문이기 때문에 key를 통해 구분해줘야함
  if (!err) {
    alert(msg)
  } else {
    boards.value.push({
      articleNo: index++,
      subject: subject.value,
      userId: userId.value,
      content: content.value,
      hit: 0,
      registerDate: makeDate()
    })
    console.log(boards.value)
    articleNo.value = ''
    subject.value = ''
    userId.value = ''
    content.value = ''
    alert('등록')
    moveHandler()
  }
}

function moveHandler() {
  console.log('moveHandler............')
  // $emit을 통해 부모 컴포넌트에게 이벤트를 전달
  // $emit('이벤트명', 전달할 데이터)
  emit('changeState', LIST)
}
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
          <mark class="sky">글쓰기</mark>
        </h2>
      </div>
      <div class="col-lg-10">
        <form id="form-register" method="POST" action="">
          <div class="mb-3">
            <label for="userid" class="form-label">작성자 ID : </label>
            <input
              v-model="userId"
              type="text"
              class="form-control"
              ref="userIdDiv"
              id="userid"
              name="userid"
              placeholder="작성자ID..."
            />
          </div>
          <div class="mb-3">
            <label for="subject" class="form-label">제목 : </label>
            <input
              v-model="subject"
              ref="subjectDiv"
              type="text"
              class="form-control"
              placeholder="제목..."
            />
          </div>
          <div class="mb-3">
            <label for="content" class="form-label">내용 : </label>
            <textarea
              v-model="content"
              class="form-control"
              ref="contentDiv"
              id="content"
              name="content"
              rows="7"
            ></textarea>
          </div>
          <div class="col-auto text-center">
            <button
              type="button"
              id="btn-register"
              class="btn btn-outline-primary mb-3"
              @click="createHandler"
            >
              글작성
            </button>
            <button type="reset" class="btn btn-outline-danger mb-3">초기화</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
