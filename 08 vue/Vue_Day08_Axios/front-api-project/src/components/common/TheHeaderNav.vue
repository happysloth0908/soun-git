<template>
  <div>
    <nav>
      <RouterLink to="/">Home</RouterLink> | 
      <RouterLink :to="{name: 'boardList'}">BoardList</RouterLink> |
      <RouterLink :to="{name: 'boardCreate'}">BoardCreate</RouterLink> 
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
