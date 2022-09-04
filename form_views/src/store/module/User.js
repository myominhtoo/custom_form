import axios from 'axios';

export default {
    state : {
        users : [],
        msg : "Hello world",
        user : {},
    },
    getters : {
        users( state ){
            return state.users;
        },
        msg( state ){
            return state.msg;
        },
        user( state ){
            return state.user;
        }
    },
    mutations : {
        setUsers( state , payload ){
            state.users = payload ;
        },
        setUser( state , payload ){
            state.user = payload;
        },
        addUser( state , payload ){
            state.users.push( payload );
        }
    },
    actions : {
        async getUsers( { commit }){
            const res = await axios.get('http://localhost:8080/api/users');
            
            commit("setUsers",res.data);
        },

        async addUser( { commit , dispatch } , user ){
            const res = await axios.post( `http://localhost:8080/api/users`, user );

            if( res.data == 1){
                commit( 'addUser' , user );
            }

        },

        async getUser( { commit } , key ){
            const res = await axios.get(`http://localhost:8080/api/users?email=${key}`);

            const users = res.data;

            if( users.length > 0 ){
                commit( "setUser" , users[0]);
            }
        }
    }
}