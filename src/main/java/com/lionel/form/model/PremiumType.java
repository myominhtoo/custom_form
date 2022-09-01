package com.lionel.form.model;

import lombok.Data;

@Data
public class PremiumType
{
    private int id;
    private String name;
    private int maxForm;
    private int maxResponse;
    private Long price;
}
