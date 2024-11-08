<template>
        <BusinessCardDetail @deleteCardEvent="deleteCard" v-for="card in businessCards" :key="card.name" :businessCard="card"/>
</template>

<script setup>
    import BusinessCardDetail from './BusinessCardDetail.vue';
    import { ref, computed, watchEffect } from 'vue';
    const count = ref(0);
    
    const businessCards = ref([
        {name: '일론 머스크', title: '테슬라 테크노킹'},
        {name: '래리 엘리슨', title : '오라클 창업주'},
        {name: '빌 게이츠', title: '마이크로소프트 공동창업주'},
        {name: '래리 페이지', title: '구글 공동창업주'},
		{name: '세르게이 브린', title: '구글 공동창업주'}
])

    function deleteCard(businessCard){
        for (let i = 0; i < businessCards.value.length ; i++){
            if(businessCards.value[i].name === businessCard.name){
                businessCards.value.splice(i, 1); // (지정한 인덱스, 삭제할 수)
            }
        }
    }
    const emit = defineEmits(["cardCountUpdate"]);

    // const countCard = computed ((businessCards.value.length), () => {
    //     console.log("123")
    //     emit('cardCountUpdate', businessCards.value.length);
    // })
    // computed 쓸거면 이렇게 써야 함. 그럼 businessCards이 바뀔 때마다 계산을 해줌. 
    // const countCard = computed(() => {
    // return businessCards.value.length;
    // })

    watchEffect(() => {
        emit('cardCountUpdate', businessCards.value.length);
    })


</script>

<style scoped>

</style>