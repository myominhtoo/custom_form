package com.lionel.form.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lionel.form.mapper.AnswerMapper;
import com.lionel.form.mapper.FormMapper;
import com.lionel.form.mapper.FormPartMapper;
import com.lionel.form.mapper.FormPartTypeMapper;
import com.lionel.form.model.Form;
import com.lionel.form.model.FormPartType;
import com.lionel.form.model.HttpResponse;

@RestController
@RequestMapping( value = "/api/")
@CrossOrigin( origins = "http://127.0.0.1:5173/" )
public class FormController
{
    @Autowired
    FormPartTypeMapper formPartTypeMapper;
    
    @Autowired
    FormMapper formMapper;

    @Autowired
    FormPartMapper formPartMapper;

    @Autowired
    AnswerMapper answerMapper;

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

        
        
        return response;
    }


}
