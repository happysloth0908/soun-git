<template>
    <div class="pageContainer">
    <header>
        <div class="pageTitle">
            <h1>명함 관리 페이지</h1>
        </div>
    </header>
    <main>
        명함을 관리하는 페이지입니다. 
    </main>
    <article>
        <h3 class="explanation">보유 명함 목록</h3>
        <h4>현재 보유중인 명함 수: {{ count }}</h4>
        <div class="BusinessCards">
            <BusinessCard class="businessCard" @cardCountUpdate="cardCountUpdate"/>
        </div>
    </article>
    <footer>
        &copy;2023 My Business Cards
    </footer>
    </div>
</template>

<script setup>
    import { ref } from 'vue';
    import BusinessCard from './components/BusinessCard.vue';
    const count = ref(0);

    function cardCountUpdate (cartCount){
        console.log(cartCount)
        count.value = cartCount;
    }

</script>

<style>
*{
margin: 0;
padding: 0;
box-sizing: border-box;
}   
</style>

<style scoped>
    .pageTitle {
        background-color: rgb(66, 154, 255);
        color: beige;
        width: 300px;
        height: 150px;
        display: flex;
        justify-content: center; /*좌우 가운데 정렬*/
        align-items: center;    /*상하 가운데 정렬*/
        margin-bottom: 40px;
    }
    header, main, article{
        display: flex;
        flex-direction: column;
        justify-content: center; /*좌우 가운데 정렬*/
        align-items: center;
    }
    .BusinessCards{
        display: flex;
        justify-content: center; /*좌우 가운데 정렬*/
        flex-wrap: wrap;        /* 줄 바꿈 허용 */
        gap: 20px;              /* 카드 사이의 간격 */
        max-width: 1020px; /* 추가: 전체 영역 너비 제한 */
    }

    .pageContainer {
        min-height: 100vh;
        margin: 0;
        display: flex;
        flex-direction: column;
    }
    article{
        min-height: 80vh;
        margin-bottom: 50px; /*footer 보다 살짝 넓게 설정*/
    }
    footer{
        margin-top: auto;
        background-color: rgb(210, 210, 210);
        width: 100%;
        text-align: center;
        padding: 10px, 0;
    }
    .explanation{
        margin: 30px;
    }


</style>