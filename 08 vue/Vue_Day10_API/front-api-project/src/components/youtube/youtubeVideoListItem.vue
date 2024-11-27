<template>
    <li>
        <img :src="video.snippet.thumnails.default.url">
        <span>{{videoTitle}}</span>
    </li>
</template>

<script setup>
import { useYoutubeStore } from '@/stores/youtube';
import { ref, computed } from 'vue';

    const store = useYoutubeStore();

    defineProps({
        video: Object
    })

    const videoTitle = computed(()=>{
        return _.unescape(props.video.snippet.title)
    })

</script>

<style scoped>

</style>