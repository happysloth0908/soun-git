import HomeView from '@/views/HomeView.vue'
import QuizView from '@/views/QuizView.vue'
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView
    },
    {
      path: "/quiz",
      name: "quiz",
      component: QuizView
      // children: [
      //   {
      //     path: '',
      //     name: 'quizDetail',
      //     component: QuizDetail
      //   }

      // ]
    }

  ],
})

export default router
