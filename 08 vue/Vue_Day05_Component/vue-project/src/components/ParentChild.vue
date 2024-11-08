<template>
    <div>
        <h4>자식 컴포넌트</h4>
        <p>{{ myMsg }}</p>
        <p v-text="myMsg"></p>
        <p>{{ dynamicName }}</p>
        <ParentGrandChild :my-msg="myMsg"/>
    </div>
</template>

<script setup>
    //부모로부터 props 를 받아 쓰는 방법 2가지
    // 1. 
    // defineProps(['myMsg'])
    // 2. 
    defineProps({
        myMsg: String,
        dynamicName: String,
    })

    import ParentGrandChild from './ParentGrandChild.vue';
</script>

<style scoped>

</style>