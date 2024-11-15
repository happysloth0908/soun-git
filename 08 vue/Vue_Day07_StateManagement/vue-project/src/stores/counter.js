import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useCounterStore = defineStore('counter', () => {
  //상태 정의
  const count = ref(0)
  //게터 정의
  const doubleCount = computed(() => count.value * 2)
  // 액션 정의
  function increment() {
    count.value++
  }

  return { count, doubleCount, increment }
})
