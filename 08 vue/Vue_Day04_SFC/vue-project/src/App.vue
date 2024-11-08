<template>
  <h2>App.vue</h2>
  <MyComponent/>
  <my-component/>
</template>

<script setup>
  // import MyComponent from './copmponents/MyComponent.vue'; // 상대경로
  import MyComponent from '@/components/MyComponent.vue';    // 절대경로 @ = src 임. 
</script>

<style scoped>
</style>