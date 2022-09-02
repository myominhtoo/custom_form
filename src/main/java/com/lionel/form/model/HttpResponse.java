package com.lionel.form.model;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class HttpResponse {
    
    private int statusCode;
    private HttpStatus status;
    private String message;

}
