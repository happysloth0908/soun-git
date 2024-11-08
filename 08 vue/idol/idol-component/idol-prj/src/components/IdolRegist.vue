<template>
      <form @submit.prevent="registerIdol">
        <p>이름 : <input type="text" v-model="idol.name"></p>
        <p>성별 : <input type="text" v-model="idol.gender"></p>
        <button>등록</button>
        <button type="button" @click="requestIdolList">취소</button>
      </form>
</template>

<script setup>
    import { ref } from 'vue';
    import axios from 'axios';
    const idol = ref({});


    const emit = defineEmits(['requestIdolList']);


    const registerIdol = async () => {
        await axios.post("http://192.168.210.40:8080/api/idol", idol.value);
        emit('requestIdolList');
    }   

    const requestIdolList = async () => {
        emit ('requestIdolList');
    }

</script>

<style scoped>

</style>