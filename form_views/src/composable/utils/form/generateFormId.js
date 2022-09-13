/*
* will do current date + random number = form_id 
*/
const generateFormId = () => {
    const date = new Date();

    let random_num = (Math.random() * 100000).toFixed(0);
    let date_string = `${date.getFullYear()}${date.getMonth()}${date.getDate()}`;
    
    return `${date_string}-${random_num}`;
   
}

export default generateFormId;