import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import BoardView from '@/views/BoardView.vue'

import BoardList from '@/components/board/BoardList.vue'
import BoardCreate from '@/components/board/BoardCreate.vue'
import BoardDetail from '@/components/board/BoardDetail.vue'
import BoardUpdate from "@/components/board/BoardUpdate.vue";

import UserLogin from '@/components/user/UserLogin.vue'
import KakaoView from '@/views/KakaoView.vue'
import YoutubeView from '@/views/YoutubeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/board',
      name: 'board',
      component: BoardView,
      children: [
        {
          path: "",
          name: "boardList",
          component: BoardList
        },
        {
          path: "create",
          name: "boardCreate",
          component: BoardCreate
        },
        {
          path: ":id",
          name: "boardDetail",
          component: BoardDetail
        },
        {
          path: "update",
          name: "boardUpdate",
          component: BoardUpdate,
        },
      ]
    },
    {
      path: "/login",
      name: "login",
      component: UserLogin
    },
    {
      path: "/kakao",
      name: "kakao",
      component: KakaoView,
    },
    {
      path: "/youtube",
      name: "youtube",
      component: YoutubeView,
    }
  ],
})

export default router
