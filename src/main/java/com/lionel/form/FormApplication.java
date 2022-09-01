package com.lionel.form;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lionel.form.mapper.AccountMapper;

@SpringBootApplication
@MappedTypes({AccountMapper.class})
@MapperScan("com.lionel.form.mapper")
public class FormApplication
{
	public static void main(String[] args) {
		SpringApplication.run(FormApplication.class, args);
	}

}
