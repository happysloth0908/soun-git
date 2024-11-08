<template>
  <header>
    <div class="title">
    <table>
      <thead>
        <tr>
          <th><h3>Quiz 퀴즈</h3></th>
        </tr> 
      </thead>
      <tbody>
        <tr>
          <td>여기는 퀴즈의 나라! 놀라운 퀴즈들이 기다리고 있어요. 지금 바로 도전해보세요!</td>
        </tr>    
      </tbody>
    </table>
  
    <nav class="nav">
      <RouterLink :to="{name: 'home'}">HOME</RouterLink>|
      <RouterLink :to="{name: 'quiz'}">Quiz</RouterLink>|
    </nav>
  </div>
  </header>
  <main>
    
    <RouterView />
  </main>
  <footer></footer>
</template>

<script setup>
import { RouterView } from 'vue-router';

</script>

<style scoped>
header{
  display: flex;
  flex-direction: column;
  align-items: center;
}
.title{
  background-color: rgb(241, 239, 239);
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 30px;
  margin-bottom: 40px;


}
table {
  border-collapse: collapse;
  width: 700px;
}
thead > tr > th{
  border-radius: 10px 10px 0 0;
  background-color: orange;
  color: white;
}
tbody > tr> td {
  /* border: solid 1px grey; */
  background-color: rgb(255, 255, 255);
  border-radius: 0px 0px 10px 10px;
  height: 100px;
  /* margin: 10px; */
  padding: 20px;
  text-align: center;
}
.nav {
  padding: 10px;
  background-color: rgb(48, 46, 46);
  color: white;
  width: 700px;
  text-align: center;
  margin: 20px;
}
main{
  display: flex;
  flex-direction: column;
  align-items: center;
}

</style>