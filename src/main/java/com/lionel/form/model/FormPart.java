package com.lionel.form.model;

import java.util.List;

import lombok.Data;

@Data
public class FormPart
{
    private String id;// to be used as composite key formId + num
    private String question;
    private int formPartTypeId;
    private int formId;    
    private List<Answer> answers;
}
