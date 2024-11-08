<template>
    <div>
        <h5>손자 컴포넌트</h5>
        <p>{{ myMsg }}</p>
    </div>
</template>

<script setup>
    defineProps({
        myMsg: String
    })

</script>

<style scoped>

</style>