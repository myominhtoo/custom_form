<template>
    <div id="search-box" class="w-50 mx-auto">
        <form @submit="handleSearchSubmit" class="w-auto d-flex position-relative">
            
            <button ref="submit" type="submit" class="d-none"></button>

            <i @click="handleSubmitClick" class="fa-solid fa-magnifying-glass my-auto search-btn"></i>

            <input type="text"
             v-model="search"
             class="w-100 mx-auto py-2 px-5"
             id="search-input"
             placeholder="Search" />
            
            <span v-if=" search != '' " @click=" () => search = ''" class="search-clear">
                <i class="fa-solid fa-xmark pale-dk my-auto mx-auto"></i>
            </span>
        </form>
    </div>
</template>

<script setup >
import { onMounted, ref } from 'vue';


const search = ref("");
const submit = ref(null);


onMounted(() => {
    document.title = "Home | Forms";
});

const handleSubmitClick = () => {
    submit.value.click()
}

const handleSearchSubmit = ( e ) => {
    e.preventDefault();

    console.log(search.value)
}


</script>
