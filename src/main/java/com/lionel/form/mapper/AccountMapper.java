package com.lionel.form.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
            @Result( property = "roleId" , column = "role_id"),
            @Result( property = "createdAt" , column = "created_at" ),
            @Result( property = "isActive" , column = "active_status" )
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
            @Result( property = "roleId" , column = "role_id"),
            @Result( property = "createdAt" , column = "created_at" ),
            @Result( property = "isActive" , column = "active_status" )
        }
    )
    List<User> findBy( User user );

    @Select("SELECT * FROM users WHERE email = #{email}")
    User findByEmail( @Param("email") String email );

    @Update( "UPDATE users SET active_status = #{status} WHERE id = #{id}" )
    int updateActiveStatus( @Param("status") int status , @Param("id") int id );

    @Update("UPDATE users SET username = #{username} , email = #{email} , password = #{password} "
            +" WHERE id = #{id} ")
    int updateOne( User user );
}
