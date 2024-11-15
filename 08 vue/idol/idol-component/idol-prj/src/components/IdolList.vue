<script setup>
    import { ref } from 'vue';
    import axios from 'axios';
    const emit = defineEmits(['detailView', 'registForm']);
    
    const detailIdol = (no) => {
        emit('detailView', no);
    }

    const currentView = ref("list");
    const idols = ref([]);  // 전체 아이돌 목록
    const requestIdolList = async () => {
        const {data} = await axios.get("http://192.168.210.40:8080/api/idol");
        idols.value = data;
        currentView.value = "list";
    }
    requestIdolList();

    const registerIdolForm = async () => {
      emit('registForm');
    }


</script>
<template>
    <div id="list" v-if="currentView === 'list'">
      <button @click="registerIdolForm">등록</button>
      <div v-for="idol in idols" :key="idol.no" 
           @click="detailIdol(idol.no)">
        <p>번호 : {{idol.no}}</p>
        <p>이름 : {{idol.name}}</p>
        <p>성별 : {{idol.gender}}</p>  
      </div>
    </div>
</template>
<style scoped>
    #list div {
      border: 1px solid #ccc;
      padding: 10px;
      margin: 5px 0;
      border-radius: 5px;
      background-color: #f9f9f9;
    }
</style>