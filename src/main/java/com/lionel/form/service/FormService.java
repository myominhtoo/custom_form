package com.lionel.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lionel.form.mapper.FormMapper;
import com.lionel.form.model.Form;

@Service
public class FormService {
    
    @Autowired
    private FormMapper formMapper;

    public boolean save( Form form ){
        boolean isSaved = false;

        if( formMapper.save( form ) > 0 ){
            isSaved = true;
        }
        
        return isSaved;

    }

}
