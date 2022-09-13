package com.lionel.form.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Form
{
    private String id;
    private String title;
    private int userId;
    private List<FormPart> formParts;
    private Date createdAt;
    private Date updatedAt;

}
