<template>
    <div id="profile-icon" class="my-auto">
        <img :src="'/src/assets/'+img" class="w-100 h-100" alt="">
    </div>
</template>

<script setup >

//define props for icon
const props = defineProps({
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