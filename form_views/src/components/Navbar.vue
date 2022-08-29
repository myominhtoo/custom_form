<template>
    <nav class="navbar navbar-expand bg-snow py-3">
        <span id="menu-btn" style="margin-left:200px;margint-right:0;"><i class="fa-solid fa-bars h4"></i></span>
        <main class="container mx-auto w-75">
            <h1 @click="() => $router.push('/')" id="brand" class="h3 pale-dark">
                <i class="fa-solid fa-file-waveform violet"></i>
                Forms
            </h1>

            <SearchBox />
            
            <ul class="navbar-nav dark gap-5">
                <ProfileIcon 
                 :user="{
                    name : 'Jennie',
                    email : 'jennie@gmail.com'
                 }"
                 img="nini.jpg"
                />
            </ul>
        </main>
    </nav>
</template>

<script setup>
import SearchBox from '../components/SearchBox.vue';
import ProfileIcon from '../components/ProfileIcon.vue';

</script>
