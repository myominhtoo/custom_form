export default ( value = "" , option = {} ) => {
    let isEmpty = value.length == "" || value.trim() == ""
    let isValid = true;
    
    if( option != undefined )
    {
        let minLength = option.min;
        let maxLength = option.max == undefined ? Infinity : option.max;

        ( value.length < minLength || value.length > maxLength )
        ? isValid = false
        : isValid = true;
    }

    return !isEmpty && isValid;
}