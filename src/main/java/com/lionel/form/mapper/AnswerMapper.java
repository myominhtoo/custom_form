package com.lionel.form.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lionel.form.model.Answer;

@Mapper
public interface AnswerMapper {
    
    @Insert("<script>"
            +" INSERT INTO answers( id , answer , status , form_part_id ) VALUES "
            +"<foreach item='ans' collection='answers' separator=',' close=';' >"
            +" ( #{ans.id} , #{ans.answer} , #{ans.status} , #{ans.formPartId} ) "
            +"</foreach>"
            +"</script>")
    int saveAll( @Param("answers") List<Answer> answers );

}
