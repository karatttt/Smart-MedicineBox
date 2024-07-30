package com.example.medicine.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicationEntity {

    Integer id;
    String name;
    String code;
    String dosage;
    String description;

}
