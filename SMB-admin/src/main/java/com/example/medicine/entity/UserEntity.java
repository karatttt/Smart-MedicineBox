package com.example.medicine.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class UserEntity {

    Integer id;
    String name;
    Integer age;
    String gender;
    Date createTime;
}
