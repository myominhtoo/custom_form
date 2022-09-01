import swal from 'sweetalert';

const useAlert = ( icon , { title = "" , text = "" } ) => {
    swal( title , text , icon );
}

export default useAlert;