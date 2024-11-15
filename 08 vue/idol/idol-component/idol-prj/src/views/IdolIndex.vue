<script setup>
    import { ref } from 'vue';
    import IdolList from '@/components/IdolList.vue';
    import IdolDetail from '@/components/IdolDetail.vue';
    import IdolRegist from '@/components/IdolRegist.vue';

    const currentView = ref("list");
    const no = ref(0);

    const doDetailView = (IdolNo) => {
        no.value = IdolNo;
        currentView.value = "detail";
    }
    const requestIdolList = () => {
        currentView.value = "list";
    }
    const doRegistForm = () => {
        currentView.value = "registForm";
    }

 
</script>
<template>
    <div>
        <IdolList @registForm="doRegistForm" @detailView="doDetailView" v-if="currentView === 'list'" />
        <IdolDetail @requestIdolList="requestIdolList" :no="no" v-if="currentView === 'detail'" />
        <IdolRegist @requestIdolList="requestIdolList" v-if="currentView === 'registForm'"/>
    </div>
</template>
<style scoped>

</style>
