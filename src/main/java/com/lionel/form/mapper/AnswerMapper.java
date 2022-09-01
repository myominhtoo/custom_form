package com.lionel.form.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.lionel.form.model.Answer;

@Mapper
public interface AnswerMapper {
    
    @Insert("INSERT INTO answers ( form_id , answer , status ) VALUES "
            +"<foreach item='answer' collection='answers' separator=',' close=';'>"
            +" ( #{answer.formId} , #{answer.answer} , #{answer.status} ) "
            +"</foreach>")
    int saveAll( List<Answer> answers );

}
