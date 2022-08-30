<template>
    <main class="w-auto h-auto">

        <Navbar />

        <div class="container w-75 mx-auto py-3 my-2">
            <h6 class="h6 pale-dk">Profile page</h6>

        </div>

    </main>
</template>

<script setup > 
import Navbar from '../components/Navbar.vue';
import { onMounted } from 'vue';

onMounted(() =>{
    document.title = "form | profiie"
});

</script>
