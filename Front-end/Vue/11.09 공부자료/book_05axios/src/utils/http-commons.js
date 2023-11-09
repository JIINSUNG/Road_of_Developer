import axios from 'axios'

const { VITE_API_BASE_URL } = import.meta.env

function localAxios() {
  const instance = axios.create({
    baseURL: VITE_API_BASE_URL,
    // 컨텐츠 타입 미리 지정
    headers: {
      'Content-type': 'application/json; charset=UTF-8'
    }
  })
  return instance
}

export { localAxios }
