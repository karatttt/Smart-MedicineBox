package com.example.medicine.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class RecordEntity {

    String medicationName;
    String userName;
    Date reminderTime;
    String dosage;
    Integer status;

}
