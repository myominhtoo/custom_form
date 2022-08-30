<template>
    <div id="profile-icon" class="my-auto d-flex gap-3 align-items-center">
        <h5 class="h5">{{ user.name }}</h5>
        <div class="dropdown">
            <img 
             :src="'/src/assets/'+img" 
             class="w-100 h-100" 
             alt="profile-icon"
             data-bs-toggle="dropdown"
             data-bs-target="#profile-dropdown" />

             <ul class="dropdown-menu" id="profile-dropdown" style="transform:translateX(-70%);">
                <li class="dropdown-item">{{ user.email }}</li>
                <li class="dropdown-item m-0"><router-link to="/me" class="text-decoration-none w-100 w-100 d-block"><i class="fa-solid fa-user-pen mx-1"></i>Edit profile</router-link></li>
                <li class="dropdown-item m-0 "><router-link to="/signin" class="text-danger text-decoration-none w-100 d-block"><i class="fa-solid fa-arrow-right-from-bracket mx-1"></i>Logout</router-link></li>
             </ul>
        </div>
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