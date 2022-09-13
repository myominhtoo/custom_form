<template>
   <main class="w-auto">
        <Navbar/>
        
        <div id="main" class="w-75 mx-auto my-5">
            <header id="form-header" class="py-5 px-5">
                <h2 class="h2 violet">Form Title</h2>
                <input type="text"
                  v-model="formData.title"
                  class="w-100 mx-auto" 
                  placeholder="Enter form's title "/>
            </header>

            <main id="form-main" class="my-4">
                <div v-for="part,index in formData.formParts" :key="part.id" id="part" class="py-5 px-5">
                    <h4 class="h5 violet my-2">({{ index + 1 }})Question</h4>
                    <div class="w-100 mx-auto d-flex gap-3">
                        <input
                         type="text"
                         v-model="part.question" 
                         class="w-100 mx-auto"
                         placeholder="Enter question "/>
                         
                         <select v-model="part.type" class="form-select w-25 text-capitalize">
                            <option disabled selected>Choose type for question</option>
                            <option v-for="partType in $store.getters.partTypes" :key="partType.id" :value="partType.id">{{ partType.name }}</option>
                         </select>
                    </div>
                    <br/>
                    <div v-if="part.type != 1" id="part-answers" class="d-flex flex-column gap-3">
                        <div v-for="answer,idx in part.answers" :key="idx" class="w-auto d-flex align-items-center gap-2">
                            <input 
                              @change="(e) => handleSetKey( index , e )"
                              :type="$store.getters.partTypes.filter( type => type.id == part.type )[0].name"
                              name="key"
                              :value="answer.id"
                              class="form-check violet" />
                            <input 
                              v-model="answer.value"
                              type="text"
                              id="part-answer"
                              :placeholder="'Answer '+(idx+1)" />
                            <!-- index is from parent , idx is child -->
                            <span 
                             v-if="part.type != 1"
                              @click="handleDeleteAnswer( index , idx )"
                              id="answer-del-btn"><i class="fa-solid fa-trash-can"></i></span>
                        </div>
                    </div>
                    <a v-if="part.answers.length < 4 && part.type != 1 "
                      @click="handleAddOption( index )" class="h6 d-block my-3" >Add Option</a>
                     <ControlPanel
                      @add:part="handleAddPart"
                      @delete:part="handleDeletePart"
                      :isLast=" index == (formData.formParts.length - 1)"
                      :cur="index"
                      />
                </div>
                <div class="d-flex justify-content-end gap-2">
                    <button @click="handleResetForm" id="form-reset-btn">Reset</button>
                    <button @click="handleCreateForm" id="form-create-btn">Create</button>
                </div>
            </main>
            <br/>
            <br/>
        </div>
        <Footer />
   </main>
</template>

<script setup >
import Navbar from '../components/Navbar.vue';
import Footer from '../components/Footer.vue';
import ControlPanel from '../components/form/ControlPanel.vue';
import { onMounted, onUpdated, reactive , ref } from "@vue/runtime-core";
import axios from 'axios';
import generateFormId from '../composable/utils/form/generateFormId.js';
import { useStore } from 'vuex';
import useAlert from '../composable/utils/useAlert.js';


const store = useStore();

onMounted(() => {
    document.title = "New | Forms";
});

onMounted(() => {
    store.dispatch( "getPartTypes" );

    formData.id = generateFormId();
    formData.formParts[0].id = `${formData.id}-1`;
});

// const partTypes = ref([
//     {
//         id : 1,
//         name : "text"
//     },
//     {
//         id : 2,
//         name : "radio"
//     },
//     {
//         id : 3,
//         name : "checkbox"
//     }
// ]);

const formData = reactive({
    id : '',
    title : "Untitled title",
    formParts : [
        {
            id : ``,
            type : 1,
            question : '',
            answers : [],
            key : [],
        },
    ]
});


const handleCreateForm = () => {

    swal({
        text : 'Are you sure to create form?',
        icon : 'warning',
        buttons : ['No','Yes'],
    }).then( isYes => {
        if( isYes ){
           
            formData.formParts = formData.formParts.map( part => {
                part.answers = part.answers.map( answer => {
                    let status = part.key.includes( `${answer.id}` ) ? true : false;
                    return { ...answer , formPartId : part.id , status };
                })
                return { ...part , formPartTypeId : part.type };
            })

            console.log( formData )

        }
    });

}


const handleAddOption = ( target ) => { 

    let prevAnswers = formData.formParts[target].answers;
    let chars = [];
    /**
     *  chars = [1,12]
     * will take 12 
     * 
     */

    if( prevAnswers.length > 0 ) chars = prevAnswers[ prevAnswers.length -1 ].id.split('-');
    
    let id = prevAnswers.length == 0 
             ? `${formData.formParts[target].id}-1`
             : `${formData.formParts[target].id}-${Number(chars[ chars.length -1 ]) + 1}`; 

    if( prevAnswers.length < 4 ){
        formData.formParts[target].answers.push({
            id : `${id}`,
            value : "",
        });
    }
} 

const handleDeleteAnswer = ( questionIdx , answerIdx ) => {

    formData.formParts[questionIdx].answers.splice( answerIdx , 1 );

}

const handleDeletePart = ( target ) => {
   if( formData.formParts.length > 1){
    
     let curPosition = window.scrollY;

     window.scrollTo( 0 , curPosition - 300 );

     formData.formParts.splice( target , 1 );

     return ;
   }

   useAlert( "warning" , {
    text : "A form must not under 1 question!!"
   } );
}

const handleAddPart = () => {
    let prevParts = formData.formParts;
    let curPosition = window.scrollY;

    if( formData.formParts.length < 10 )
    {
        window.scrollTo( 0  , curPosition + 500 );

        let chars = prevParts[prevParts.length - 1].id.split('-');
        let prevId = Number(chars[chars.length - 1]);
        let id = `${formData.id}-${prevId + 1}`;

        formData.formParts.push( {
            id ,
            type : 1,
            question : '',
            answers : [],
            key : [],      
        } )

        return ;
    }

    useAlert( "warning" , {
        text : "You need to buy premium to do!!"
    });
}


const handleResetForm = () => {
    formData.formParts.splice( 1 );
    formData.title = "";
}

const handleSetKey = ( target , e ) => {
    const curType = formData.formParts[target].type;

    if( curType == 2 )
    {
        formData.formParts[target].key.splice(0);
        formData.formParts[target].key.push( e.target.value );
    }

    if( curType == 3 )
    {
        let curKeys = formData.formParts[target].key;//datas before now
        let val = e.target.value;//checked value

        if( curKeys.includes( val ))
        {
            let savedIdx = curKeys.findIndex(( v ) => v  == val );
            curKeys.splice( savedIdx , 1 );//if haved included , will remove

            return ;
        }
        curKeys.push( val );
    }



}


</script>