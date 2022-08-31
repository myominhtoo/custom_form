<template>
    <main class="w-auto h-auto">

        <Navbar />

        <div class="container w-75 mx-auto py-3 my-2">
            <h6 class="h6 pale-dk">Create Your New Form</h6>

            <div class="w-100 my-3">
                <SmallBox 
                 type="Blank"
                 img="create.png"
                 />
            </div>

            <div v-for=" user in $store.getters.users" :key="user.id">
                {{ user.username }}
            </div>
        </div>
    </main>
</template>

<script setup >
import { useStore } from 'vuex';
import { onMounted , ref } from '@vue/runtime-core';
import Navbar from '../components/Navbar.vue';
import SmallBox from '../components/SmallBox.vue';

const store = useStore();

onMounted(() => {
    document.title = "Home | Forms";
});

onMounted(() => {
    store.dispatch( "getUsers" );
});



</script>
