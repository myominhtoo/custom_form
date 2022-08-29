package com.lionel.form.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lionel.form.mapper.AccountMapper;
import com.lionel.form.model.User;

@RestController
@RequestMapping( value = "/api/" )
public class AccountController
{
    @Autowired
    AccountMapper accountMapper;
    
    @GetMapping("/users")
    public List<User> getUsers( HttpServletRequest req )
    {
        String id =  req.getParameter("id");
        String email = req.getParameter("email");

        User user = new User();    
        List<User> users = new ArrayList<>();
        
        if( id != null && email == null )
        {
            user.setId(Integer.parseInt(id));
            users = accountMapper.findBy(user);
        }
        else if( id == null && email != null )
        {
            user.setEmail( email );
            users = accountMapper.findBy(user);
        }
        else
        {
            users = accountMapper.find();
        }
        return users;
    }

    @PostMapping("/users")
    public int postCreateUser(@RequestBody User user )
    {
        return accountMapper.save(user);
    }

}
