package com.lionel.form.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lionel.form.model.FormPart;

@Mapper
public interface FormPartMapper {
    
    @Insert("INSERT INTO form_parts ( question , form_part_type_id , form_id ) VALUES "
            +"<foreach item='part' collection='parts' separator=',' close=';' >"
            +" ( #{part.question} , #{part.formPartTypeId} , #{part.formId} ) "
            +"</foreach>"
            +"")
    int saveAll( @Param("parts") List<FormPart> parts );

}
