<template>
    <div @click="() => $router.push('/forms/new')" id="small-box" class="p-0">
        <div class="container-fluid w-100 h-100 d-flex justify-content-center-align-items-center p-0 my-1">
            <img :src="'/src/assets/'+img" alt="" />
        </div>
        <span class="text-start violet" id="box-type">{{ type }}</span>
    </div>
</template>

<script setup >

const props = defineProps({
    type : {
        type : String,
        default : "",
    },
    img : {
        type : String,
        default : ""
    }
});

</script>