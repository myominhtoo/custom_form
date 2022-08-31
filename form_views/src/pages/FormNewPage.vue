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
                <div v-for="part,index in formData.parts" :key="part.id" id="part" class="py-5 px-5">
                    <h4 class="h5 violet my-2">({{ index + 1 }})Question</h4>
                    <div class="w-100 mx-auto d-flex gap-3">
                        <input
                         type="text"
                         v-model="part.title" 
                         class="w-100 mx-auto"
                         placeholder="Enter question "/>
                         
                         <select v-model="part.type" class="form-select w-25 text-capitalize">
                            <option disabled selected>Choose type for question</option>
                            <option v-for="partType in partTypes" :key="partType.id" :value="partType.id">{{ partType.name }}</option>
                         </select>
                    </div>
                    <br/>
                    <div v-if="part.type != 1" id="part-answers" class="d-flex flex-column gap-3">
                        <div 
                          v-for="answer,idx in part.answers"
                          :key="idx"
                          class="w-auto d-flex align-items-center gap-2">
                            <input 
                              @change="(e) => handleSetKey( index , e )"
                              :type="partTypes.filter( type => type.id == part.type )[0].name"
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
                    <a 
                     v-if="part.answers.length < 4 && part.type != 1 "
                     @click="handleAddOption( index )" class="h6 d-block my-3" >Add Option</a>
                     <ControlPanel
                      @add:part="handleAddPart"
                      @delete:part="handleDeletePart"
                      :isLast=" index == (formData.parts.length - 1)"
                      :cur="index"
                      />
                </div>
                <div class="d-flex justify-content-end gap-2">
                    <button @click="handleResetForm" id="form-reset-btn">Reset</button>
                    <button id="form-create-btn">Create</button>
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

onMounted(() => {
    document.title = "New | Forms";
});

const partTypes = ref([
    {
        id : 1,
        name : "text"
    },
    {
        id : 2,
        name : "radio"
    },
    {
        id : 3,
        name : "checkbox"
    }
]);

const formData = reactive({
    title : "Untitled title",
    parts : [
        {
            id : 1,
            type : 1,
            title : "",
            answers : [/* {
                id : 1,
                value : "",
            } */],
            key : null,
        },
        {
            id : 2,
            type : 1,
            title : "",
            answers : [ {
                id : 1,
                value : "",
            } ],
            key : null,
        }
    ]
});

const handleAddOption = ( target ) => { 

    let prevAnswers = formData.parts[target].answers;

    if( prevAnswers.length < 4 ){
        let lastId = prevAnswers[prevAnswers.length - 1 ];
        let cur = lastId == null ? 1 : ( lastId.id + 1);
        formData.parts[target].answers.push({
            id : cur,
            value : "",
        });
    }
} 

const handleDeleteAnswer = ( questionIdx , answerIdx ) => {

    formData.parts[questionIdx].answers.splice( answerIdx , 1 );

}

const handleDeletePart = ( target ) => {
   if( formData.parts.length > 1){
    formData.parts.splice( target , 1 );
   }
}

const handleAddPart = () => {
    let prevParts = formData.parts;
    formData.parts.push( {
        id : prevParts[prevParts.length - 1] + 1,
        type : 1,
        title : "",
        answers : [],
        key : ""      
    } )
}


const handleResetForm = () => {
    formData.parts.splice( 1 );
    formData.title = "";
}

const handleSetKey = ( target , e ) => {
    const curType = formData.parts[target].type;

    if( curType == 2 )
    {
        formData.parts[target].key = e.target.value;
    }

    if( curType == 3 )
    {
        let curKeys = formData.parts[target].key;

       if( curKeys == null )
       {
         formData.parts[target].key = [];
       }

       formData.parts[target].key.push( e.target.value );
    }
}

</script>