<script setup>
    import { ref } from 'vue';
    import axios from 'axios';

    const emit = defineEmits(['requestIdolList']);

    const idol = ref({});  // 선택한 아이돌 상세 정보
        const props = defineProps(['no']);

        const detailIdol = async () => {
          const {data} = await axios.get(`http://192.168.210.40:8080/api/idol/${props.no}`);
          idol.value = data;
        };
        detailIdol();


        const deleteIdol = async () => {
          await axios.delete(`http://192.168.210.40:8080/api/idol/${props.no}`);
          emit ('requestIdolList');
        }

        const requestIdolList = async () => {
            emit ('requestIdolList');
        }


</script>
<template>
    <div id="detail">
      <div>
        <p>번호 : {{idol.no}}</p>
        <p>이름 : {{idol.name}}</p>
        <p>성별 : {{idol.gender}}</p>  
      </div>
      <button @click="deleteIdol(idol.no)">삭제</button>
      <button @click="requestIdolList">목록</button>
    </div>
</template>
<style scoped>
</style>
