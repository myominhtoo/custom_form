import error from '../data/userError.js';

export default () => {
    let OK = false;

    OK = !error.username.hasError && !error.password.hasError && !error.confirm.hasError && !error.confirm.hasError;

    return {
        OK
    }
}