package com.lionel.form.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lionel.form.model.FormPart;

@Mapper
public interface FormPartMapper {
    
    @Insert("<script>INSERT INTO form_parts ( id ,  question , form_part_type_id , form_id ) VALUES "
            +"<foreach item='part' collection='parts' separator=',' close=';' >"
            +" ( #{part.id} ,  #{part.question} , #{part.formPartTypeId} , #{part.formId} ) "
            +"</foreach>"
            +"</script>")
    int saveAll( @Param("parts") List<FormPart> parts );

}
