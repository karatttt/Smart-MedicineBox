package com.example.reminder.service;

import com.example.reminder.domain.dto.ReminderReq;
import com.example.reminder.domain.po.Reminder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liushizhan
* @description 针对表【reminder】的数据库操作Service
* @createDate 2024-10-01 13:29:15
*/
public interface ReminderService extends IService<Reminder> {

    void addReminder(ReminderReq reminderReq);
}
