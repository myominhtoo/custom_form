package com.lionel.form.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lionel.form.mapper.AnswerMapper;
import com.lionel.form.model.Answer;

@Service
public class AnswerService {
    
    @Autowired
    private AnswerMapper answerMapper;

    public boolean saveAll( List<Answer> answers ){
        boolean isSaved = false;

        if( answerMapper.saveAll( answers ) > 0 ){
            isSaved = true;
        }

        return isSaved;
    }

}
