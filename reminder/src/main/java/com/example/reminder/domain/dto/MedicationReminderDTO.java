package com.example.reminder.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicationReminderDTO {
    Date begin_date;
    Date reminder_time;
    Integer cycle;
    // if not in powerjob. is null
    Long jobId;

}
