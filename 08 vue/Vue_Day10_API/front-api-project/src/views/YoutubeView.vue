<template>
    <div>
        <h2>YoutubeView</h2>
        <!-- 검색 -->
        <youtubeVideoSearch/>
         <!-- 상세 보기 -->
          <!-- 리스트 -->
        <hr>
        <youtubeVideoList/>
    </div>
</template>

<script setup>
import youtubeVideoSearch from '@/components/youtube/youtubeVideoSearch.vue';
import youtubeVideoList from '@/components/youtube/youtubeVideoList.vue';


</script>

<style scoped>

</style>