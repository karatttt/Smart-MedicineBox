package com.example.reminder.mapper;

import com.example.reminder.domain.po.Reminder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author liushizhan
* @description 针对表【reminder】的数据库操作Mapper
* @createDate 2024-10-01 13:29:15
* @Entity generate.domain.Reminder
*/
@Mapper
public interface ReminderMapper extends BaseMapper<Reminder> {

}




