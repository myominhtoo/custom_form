import axios from 'axios';

export default {
    state : {
        partTypes : [],
    },
    getters : {
        partTypes( state ){
            return state.partTypes;    
        }
    },
    mutations : {
        setPartTypes( state , payload  ){
            state.partTypes = payload;
        }
    },
    actions : {
        async getPartTypes( { commit } ){
            const res = await axios.get("http://localhost:8080/api/forms/parts/types");
            
            commit( "setPartTypes" , res.data );
        }
    }
}