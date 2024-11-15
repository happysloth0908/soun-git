<template>
  <div>
    <nav>
      <RouterLink to="/">Home</RouterLink> | 
      <RouterLink :to="{name: 'boardList'}">BoardList</RouterLink> |
      <RouterLink :to="{name: 'boardCreate'}">BoardCreate</RouterLink> | 
      <RouterLink :to="{ name: 'login' }">Login</RouterLink> |
      <RouterLink :to="{ name: 'kakao' }">KakaoMap</RouterLink> |
      <RouterLink :to="{ name: 'youtube' }">Youtube</RouterLink> |
    </nav>
  </div>
</template>

<script setup>

</script>

<style scoped>
  nav {
    text-align: center;
  }
  nav a {
    font-weight: bold;
    text-decoration: none;
    color: black;
  }
  nav a.router-link-exact-active {
    color: #42b983
  }
</style>
