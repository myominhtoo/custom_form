<template>
   <main class="w-auto h-auto">
        <Navbar/>
        <h2>Form new page</h2>
   </main>
</template>

<script setup >
import Navbar from '../components/Navbar.vue';
import { onMounted } from "@vue/runtime-core";


onMounted(() => {
    document.title = "New | Forms";
});

</script>