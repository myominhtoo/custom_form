import user from '../data/user.js';

export default () => {

    for( let key in user ){
        if( typeof user[key] != 'boolean' ){
            user[key] = "";
        }
    }

}