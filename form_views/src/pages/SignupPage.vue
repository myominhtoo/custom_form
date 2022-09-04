<template>
    <main class="w-100 d-flex justify-content-center align-items-center gap-2 flex-column row" style="height:100vh">
        <FormContainer>
            <Form :onSubmit="handleSignUp">
                <h3 class="h3 text-center mb-2 violet">SIGN UP ACCOUNT</h3>
            
                <FormGroup>
                    <label for="" class="form-label my-1">Username</label>
                    <input 
                    type="text" 
                    class="w-100"
                    v-model="user.username"
                    placeholder="Enter username"
                    autofocus/>
                    <span v-if="error.username.hasError" class="error">{{ error.username.msg }}</span>
                </FormGroup>

                <FormGroup>
                    <label for="" class="form-label my-1">Email</label>
                    <input 
                    type="email" 
                    class="w-100"
                    v-model="user.email"
                    placeholder="Enter email address"/>
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

                <FormGroup>
                    <label for="" class="form-label my-1">Confirm-Password</label>
                    <input 
                    type="password" 
                    class="w-100"
                    v-model="user.confirm"
                    placeholder="Enter confirm-password"/>
                    <span v-if="error.confirm.hasError" class="error">{{ error.confirm.msg }}</span>
                </FormGroup>

                <button type="submit" class="btn w-100 btn-primary snow bold my-2">{{ isRegistering ? "Registering..." : "Register"}}</button>
                
                <div class="text-center py-2">
                    <router-link to="/signin" class="h6">Already registered?</router-link>
                </div>
            </Form>
        </FormContainer>
    </main>
</template>

<script setup >
import Form  from '../components/Form.vue';
import FormGroup from '../components/FormGroup.vue';
import FormContainer from '../components/FormContainer.vue';
import { onMounted , ref } from "@vue/runtime-core";
import user from '../composable/data/user.js'
import error from '../composable/data/userError.js';
import validate from '../composable/utils/userValidate.js';
import check from '../composable/utils/userErrorCheck.js';
import bind from '../composable/utils/bindError.js';
import userReset from '../composable/utils/userReset.js';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';

const isRegistering = ref( false );
const store = useStore();

const router = useRouter();

onMounted(() => {
    document.title = "SignUp | Forms";
});

const handleSignUp = ( e ) => {
    e.preventDefault();

    check( "username" , validate(user.username) );
    check( "email" , validate(user.email) )
    check( "password" , validate(user.password) );
    check( "confirm" , validate(user.confirm) );

    if( user.confirm != user.password && user.confirm != "" && user.password != "" ){
        let msg = { hasError : true , msg : "Password must be same with confirm-password!" };
        error.password = msg;
        error.confirm = msg;
    }

    if( bind().OK ){
        isRegistering.value = true;
        
        store.dispatch( "addUser" , {
            username : user.username , 
            email : user.email,
            password : user.password,
            role_id : 1
        } ).then( () => {
            isRegistering.value = false;
            userReset();
            router.push( { path :"/signin" , query : { "msg" : "Successfully Registered!" , "error" : false } } );

        })

    }


}

</script>