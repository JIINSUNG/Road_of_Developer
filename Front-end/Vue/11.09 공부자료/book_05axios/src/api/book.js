// API 통신 모아놓기
import { localAxios } from '@/utils/http-commons'

const local = localAxios()

// 책 목록 조회
function listBook(params, success, fail) {
  local.get('books', { params }).then(success).catch(fail)
}

function detailBook(isbn, success, fail) {
  local.get(`books/${isbn}`).then(success).catch(fail)
}

function registBook(book, success, fail) {
  local.post(`books`, JSON.stringify(book)).then(success).catch(fail)
}

function removeBook(isbn, success, fail) {
  local.delete(`books/${isbn}`).then(success).catch(fail)
}

function updateBook(book, success, fail) {
  local.put(`books`, JSON.stringify(book)).then(success).catch(fail)
}

export { listBook, detailBook, registBook, removeBook, updateBook }
