import axios from 'axios';

export default {
    state : {
        users : [],
        msg : "Hello world",
    },
    getters : {
        users( state ){
            return state.users;
        },
        msg( state ){
            return state.msg;
        }
    },
    mutations : {
        setUsers( state , payload ){
            state.users = payload ;
        }
    },
    actions : {
        async getUsers( { commit }){
            const res = await axios.get('http://localhost:8080/api/users');
            
            commit("setUsers",res.data);
        },

        async addUser( { dispatch } , user ){
            const res = await axios.post( `http://localhost:8080/api/users`, user );

            if( res.data == 1){
                dispatch("getUsers");
            }

        }
    }
}