package com.lionel.form.model;

import lombok.Data;

@Data
public class Answer
{ 
    private String id;// to be used composite key formId + formPartId
    private String answer;
    private boolean status;    
    private String formPartId;
}
