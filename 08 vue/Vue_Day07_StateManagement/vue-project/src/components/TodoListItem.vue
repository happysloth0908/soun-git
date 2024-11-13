<template>
    <div>
        <!-- <h4>TodoListItem</h4> -->
        <span>{{  todo.text  }}</span>
        <button @click="store.deleteTodo(todo.id)">X</button>
    </div>
</template>

<script setup>
    import { useTodosStore } from '@/stores/todos';

    const store = useTodosStore();

    defineProps({
        todo: Object
    })

</script>
<style scoped>

</style>