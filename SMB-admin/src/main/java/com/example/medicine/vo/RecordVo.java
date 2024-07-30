package com.example.medicine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecordVo {


    String medicationName;
    String UserName;
    String reminderTime;
    String dosage;
    Integer status;


}
