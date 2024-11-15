import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useTodosStore = defineStore('todos', () => {
  let id = 0 // 임시 변수
  //state
   const todos = ref([
    {id: id++, text: '잠자기', isDone: false}, 
    {id: id++, text: '밥 먹기', isDone: false}, 
    {id: id++, text: '뷰 복습', isDone: false}, 
   ])
   //action 
   const addTodo = function(todoText){
    todos.value.push({
        id: id++,
        text: todoText, // 만약 파라미터 명이 그냥  text 였으면 그냥 text 라고 쓰기 가능
        isDone: false
    })
   }

   const deleteTodo = function(id){
    const idx = todos.value.findIndex((todo) => {
        return todo.id === id
    })
    todos.value.splice(idx, 1)
   }
  return { todos, addTodo ,deleteTodo }
})
