import { createRouter, createWebHistory } from 'vue-router'
import TheHomeView from '@/views/TheHomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  // 히스토리모드 -> 히스토리가 쌓임, 단점은 새로고침시 히스토리가 날라감, 홈페이지로 초기화됨
  // 해시모드 -> 새로고침시에도 현재 페이지 유지, 단점은 url에 #이 붙음
  routes: [
    {
      path: '/',
      name: 'main',
      component: TheHomeView
      // 첫화면은 정적바인딩하기
    },
    {
      path: '/book',
      name: 'book',
      component: () => import('@/views/TheBookView.vue'),
      redirect: { name: 'book-list' },
      children: [
        {
          path: 'list', // children 에선 /book/list 가 아닌 list만 써야하지만 /book/list로 써도 상관없음
          name: 'book-list',
          component: () => import('@/components/book/BookList.vue')
        },
        {
          path: 'view', // children 에선 /book/list 가 아닌 list만 써야하지만 /book/list로 써도 상관없음
          name: 'book-view',
          component: () => import('@/components/book/BookDetail.vue')
        },
        {
          path: 'regist', // children 에선 /book/list 가 아닌 list만 써야하지만 /book/list로 써도 상관없음
          name: 'book-regist',
          component: () => import('@/components/book/BookRegist.vue')
        }
      ]
    },

    {}
  ]
})
export default router
