import { reactive } from 'vue';

export default reactive({
    username : {
        hasError : false,
        msg : "",
    },
    email : {
        hasError : false,
        msg : "",
    },
    password : {
        hasError : false,
        msg : "",
    },
    confirm : {
        hasError : false,
        msg : "",
    },
    isAccept : {
        hasError : false,
        msg : "",
    }
});