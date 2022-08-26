<template>
    <div id="profile-icon" class="my-auto d-flex gap-3 align-items-center">
        <h5 class="h5">{{ user.name }}</h5>
        <img :src="'/src/assets/'+img" class="w-100 h-100" alt="">
    </div>
</template>

<script setup >

//define props for icon
const props = defineProps({
    user : {
        type : Object,
        default : {}
    },
    img : {
        type : String,
        default : "",
    },
    msg : {
        type : String,
        default : ""
    }
});


</script>