package com.lionel.form.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lionel.form.mapper.FormPartMapper;
import com.lionel.form.model.FormPart;

@Service
public class FormPartService 
{
    
    @Autowired
    private FormPartMapper formPartMapper;

    public boolean saveAll( List<FormPart> parts ){
        boolean isSaved = false;
        
        if( formPartMapper.saveAll(parts) > 0 ){
            isSaved = true;
        }

        return isSaved;
    }

}
