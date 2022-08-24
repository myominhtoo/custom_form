package com.lionel.form.model;

import lombok.Data;

@Data
public class FormPart
{
    private int id;
    private String question;
    private int formPartTypeId;
    private int formId;    
}
