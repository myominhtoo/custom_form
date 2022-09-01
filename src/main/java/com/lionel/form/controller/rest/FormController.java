package com.lionel.form.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lionel.form.mapper.FormPartTypeMapper;
import com.lionel.form.model.FormPartType;

@RestController
@RequestMapping( value = "/api/")
@CrossOrigin( origins = "http://127.0.0.1:5173/" )
public class FormController
{
    @Autowired
    FormPartTypeMapper formPartTypeMapper;

    @GetMapping( "/forms/parts/types" )
    public List<FormPartType> getFormPartTypes()
    {
        return formPartTypeMapper.find();
    }
}
