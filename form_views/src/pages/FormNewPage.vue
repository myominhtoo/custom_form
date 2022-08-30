<template>
   <main class="w-auto h-auto">
        <Navbar/>
        
        <div id="main" class="w-75 mx-auto my-5" style="height:300px;">
            <header id="form-header" class="bg-snow py-5 px-5">\
                <h2 class="h2 violet">Form Title</h2>
                <input type="text" v-model="formData.title" class="form-control mx-auto">
            </header>

            <main id="form-main">
                <div id="part" class="py-5 px-5">
                    
                </div>
            </main>
        </div>
   </main>
</template>

<script setup >
import Navbar from '../components/Navbar.vue';
import Control from '../components/creation/Control.vue';
import { onMounted, reactive } from "@vue/runtime-core";

onMounted(() => {
    document.title = "New | Forms";
});

const formData = reactive({
    title : "Untitled title",
    parts : [
        {
            id : 1,
            type : "text",
            title : "",
            answers : [],
            key : "",
        }
    ]
});


</script>