package com.lionel.form.mapper;

import java.util.List;

import com.lionel.form.model.FormPartType;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FormPartTypeMapper
{
    @Select("SELECT * FROM form_part_types")
    List<FormPartType> find();
}
