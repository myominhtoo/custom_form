<template>
     <main class="w-100 h-100">
        <Navbar/>
        <h1>form  page</h1>

        <Footer />
    </main>
</template>

<script setup >
import Navbar from '../components/Navbar.vue';
import Footer from '../components/Footer.vue';
import { onMounted } from "@vue/runtime-core";


onMounted(() => {
    document.title = "Form | Forms";
});

</script>