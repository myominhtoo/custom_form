<template>
    <main class="w-100 d-flex justify-content-center align-items-center gap-2 flex-column row" style="height:100vh">
        <FormContainer>
            <Form :onSubmit="handleSignIn">
                <h3 class="h3 text-center mb-4 violet">SIGN IN YOUR ACCOUNT</h3>

                <h6 v-if="$route.query.msg != undefined" :class="{ error : $route.query.error == 'true' ? true : false, success : $route.query.error == 'true' ? false : true }" class="h6 text-center my-2">{{ $route.query.msg }}</h6>

                <FormGroup>
                    <label for="" class="form-label my-1">Email</label>
                    <input 
                    type="email" 
                    class="w-100"
                    v-model="user.email"
                    placeholder="Enter email address"
                    autofocus/>
                    <span v-if="error.email.hasError" class="error">{{ error.email.msg }}</span>
                </FormGroup>

                <FormGroup>
                    <label for="" class="form-label my-1">Password</label>
                    <input 
                    type="password" 
                    class="w-100"
                    v-model="user.password"
                    placeholder="Enter password"/>
                    <span v-if="error.password.hasError" class="error">{{ error.password.msg }}</span>
                </FormGroup>

                <button type="submit" class="btn w-100 btn-primary snow bold my-2">LOGIN</button>
                
                <div class="text-center py-2">
                    <router-link to="/signup" class="h6">Create account?</router-link>
                </div>
            </Form>
        </FormContainer>
    </main>
</template>

<script setup >
import Form  from '../components/Form.vue';
import FormGroup from '../components/FormGroup.vue';
import FormContainer from '../components/FormContainer.vue';
import { onMounted } from "@vue/runtime-core";
import user from '../composable/data/user.js'
import error from '../composable/data/userError.js';
import validate from '../composable/utils/userValidate.js';


onMounted(() => {
    document.title = "SignIn | Forms";
});

const handleSignIn = ( e ) => {
    e.preventDefault();

}

</script>