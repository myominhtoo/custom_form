<template>
    <main class="w-100 h-100">
        <Navbar/>
        <h1>form response page</h1>
    </main>
</template>

<script setup >
import Navbar from '../components/Navbar.vue';
import { onMounted } from "@vue/runtime-core";


onMounted(() => {
    document.title = "Response | Forms";
});

</script>