package com.example.reminder.domain.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReminderReq {

    Long user_id;
    Long medication_id;
    Date begin_date;
    Integer cycle;
    Date reminder_time;


}
