<template>
    <div id="control-panel" class="p-3 bg-primary d-flex flex-column gap-2 align-items-center">
        <span @click="$emit('add:part')" v-if="isLast" class="p-2"><i class="fa-solid fa-circle-plus"></i></span>
        <span @click="$emit('delete:part',cur)" class="p-2" :disabled="isLast ? true : false "><i class="fa-solid fa-trash-can"></i></span>
    </div>
</template>

<script setup >

defineProps({
   isLast : {
     type : Boolean,
     default : false
   },
   cur : {
     type : Number,
     default : 0
   }
});

const emits = defineEmits([
    "delete:part",
    "add:part"
]);


</script>