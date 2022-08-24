package com.lionel.form.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PremiumUser
{
    private int id;
    private int userId;
    private LocalDate started_date;
    private LocalDate expired_date;
    private int premiumTypeId ;
}
