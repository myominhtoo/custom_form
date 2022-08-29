package com.lionel.form.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.lionel.form.model.User;

@Mapper
public interface AccountMapper {
    
    @Select("SELECT * FROM users")
    @Results(
        value = {
            @Result( property =  "id" , column = "id"),
            @Result( property =  "username" , column = "username"),
            @Result( property =  "email" , column =  "email"),
            @Result( property = "password" , column =  "password"),
            @Result( property = "roleId" , column = "role_id")
        }
    )
    List<User> find();
    
    @Insert("INSERT INTO users (username,email,password) "
            +"VALUE( #{username} , #{email} , #{password})")
    int save( User user );

    @Select("<script>"
            +"SELECT * FROM users WHERE "
            +"<if test='id != null and email == null '>"
            +" id = #{id}"
            +"</if>"
            +"<if test='email != null'>"
            +" email = #{email} "
            +"</if>"
            +"</script>")
    @Results(
        value = {
            @Result( property =  "id" , column = "id"),
            @Result( property =  "username" , column = "username"),
            @Result( property =  "email" , column =  "email"),
            @Result( property = "password" , column =  "password"),
            @Result( property = "roleId" , column = "role_id")
        }
    )
    List<User> findBy( User user );
}
