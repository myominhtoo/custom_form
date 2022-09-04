import error from '../data/userError.js';

export default ( target = "" , validate ) => {

    if( validate ){
        error[target].hasError = false;
        error[target].msg = '';
    }else{
        error[target].hasError = true;
        error[target].msg = `${target.toUpperCase()} must not be empty or valid!`;
    }

}