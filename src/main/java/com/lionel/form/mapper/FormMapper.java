package com.lionel.form.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.lionel.form.model.Form;

@Mapper
public interface FormMapper
{
    @Insert("INSERT INTO forms ( title , user_id ) VALUE ( #{title} , #{user_id} )")
    int save( Form form );
}
