<template>
    <div>
        <h4>검색결과</h4>
        <youtubeVideoListItem
            v-for="video in store.videoList"
            :key="video.id.videoId"
            :video="video"
        />

    </div>
</template>

<script setup>
import { useYoutubeStore } from '@/stores/youtube';
import youtubeVideoListItem from './youtubeVideoListItem.vue';
import { ref } from 'vue';

    const store = useYoutubeStore();


</script>

<style scoped>

</style>