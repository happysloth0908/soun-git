<template>
    <div class="businessCard" >
        <h3 >이름: {{ businessCard.name }}</h3>
        <h5>직함: {{ businessCard.title }} </h5>
        <button @click="deleteCardFunc()">명함 삭제</button>
    </div>
</template>

<script setup>
    const props = defineProps({
        businessCard: Object,
    })
    const emit = defineEmits(["deleteCardEvent"]);

    function deleteCardFunc (){
        emit ("deleteCardEvent", props.businessCard);
    }

</script>
<style scoped>
    .businessCard{
        border: 1px solid rgb(88, 88, 88);
        border-radius: 10px;
        background-color: rgb(220, 220, 220);
        width: 400px;
        height: 150px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
</style>