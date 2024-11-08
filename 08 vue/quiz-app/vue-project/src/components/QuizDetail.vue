<template>
    <div>
       <div class="questionCard" v-for="quiz in quizes" :key="quiz.pk">
            <h3>{{quiz.pk}}번 문제. {{ quiz.question }}</h3>
            <p>정답 입력</p>
            <input>
       </div>
    </div>
</template>

<script setup>
    defineProps ({
        quizes: Array,
    })
</script>

<style scoped>

    .questionCard{
        background-color: rgb(243, 242, 242);
        padding: 30px;
        border-radius: 20px;
        margin: 30px;
    }
    input{
        width: 100%;
        height: 40px;
        border: none;
        border-radius: 5px;
    }
</style>