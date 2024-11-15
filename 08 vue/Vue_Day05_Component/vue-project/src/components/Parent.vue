<template>
    <div>
        <h3>부모 컴포넌트</h3>
        <ParentChild my-msg="message" :dynamic-name="name"/>
    </div>
</template>

<script setup>
    import { ref } from 'vue'
    import ParentChild from './ParentChild.vue';

    const name = ref("kim")
</script>

<style scoped>

</style>