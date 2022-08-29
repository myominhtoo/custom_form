<template>
    <form @submit="onSubmit"> 
        <slot/>
    </form>
</template>

<script setup >

defineProps({
    onSubmit : {
        type : Function,
        default : () => console.log("submitted")
    },
});

</script>