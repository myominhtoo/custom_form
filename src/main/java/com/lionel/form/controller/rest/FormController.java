package com.lionel.form.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lionel.form.mapper.FormPartTypeMapper;
import com.lionel.form.model.Answer;
import com.lionel.form.model.Form;
import com.lionel.form.model.FormPart;
import com.lionel.form.model.FormPartType;
import com.lionel.form.model.HttpResponse;
import com.lionel.form.service.AnswerService;
import com.lionel.form.service.FormPartService;
import com.lionel.form.service.FormService;

@RestController
@RequestMapping( value = "/api/")
@CrossOrigin( origins = "http://127.0.0.1:5173/" )
public class FormController
{
    @Autowired
    FormPartTypeMapper formPartTypeMapper;
    
    @Autowired
    FormService formService;

    @Autowired
    FormPartService formPartService;

    @Autowired
    AnswerService answerService;

    //for getting form types
    @GetMapping( "/forms/parts/types" )
    public List<FormPartType> getFormPartTypes()
    {
        return formPartTypeMapper.find();
    }

    //for creating form
    @PostMapping( value = "/forms" )
    public HttpResponse postCreateForm( @RequestBody Form form )
    {
        HttpResponse response = new HttpResponse();
    
        boolean isSavedForm = formService.save( form );
        boolean isSavedParts = formPartService.saveAll( form.getFormParts() );
        boolean isSavedAnswers = true;
        System.out.println(form);
        /*
         *  can't access outer scope from Function 
         */

        // form.getFormParts().stream().forEach( part -> {
        //     isSavedAnswers = answerService.saveAll(part.getAnswers()) && isSavedAnswers;
        // });

        for( FormPart part : form.getFormParts() ){
           if( !part.getAnswers().isEmpty() ){
                isSavedAnswers = answerService.saveAll( part.getAnswers() ) && isSavedAnswers;
           }
        }

        if( isSavedForm && isSavedParts && isSavedAnswers ){
          response.setMsg("Successfully Created!");
          response.setStatus( HttpStatus.CREATED );
          response.setStatusCode( 201 );
          response.setOk( true );
        }else{
            response.setMsg("There was error in creating form!");
            response.setStatus( HttpStatus.BAD_REQUEST );
            response.setStatusCode( 400 );
            response.setOk( false );
        }

        
        return response;
    }


}
