<template>
  <div>
    <h2>App.vue</h2>
    <nav>
      <RouterLink to="/">Home</RouterLink> |
      <RouterLink to="/about">about</RouterLink>
      <RouterLink :to="{name: 'home'}">HomeName</RouterLink> |
      <RouterLink :to="{name: 'about'}">aboutName</RouterLink>

      <!--같은거임.url 일부는 파람 -->
      <RouterLink to="/user/ssafy"></RouterLink>
      <RouterLink to="{name: user, params: {id:'ssafy'}}"></RouterLink>

      <RouterLink to="/user?id=ssafy"></RouterLink>
      <RouterLink to="{name: 'user', query: {id:'ssafy'}}"></RouterLink>
 


    </nav>
    <RouterView/> <!--전역으로 컴포넌트 등록 되어 있어서 따로 import 해줄 필요 없음 -->
    </div>
</template>

<script setup>

import { useRouter } from 'vue-router';
const router = useRouter(); // 라우터 정보 전체 사용



</script>

<style scoped>

</style>