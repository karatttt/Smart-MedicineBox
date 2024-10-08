package com.example.reminder.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.reminder.constant.DBConstant;
import com.example.reminder.domain.dto.MedicationReminderDTO;
import com.example.reminder.domain.dto.ReminderReq;
import com.example.reminder.domain.po.Reminder;
import com.example.reminder.service.ReminderService;
import com.example.reminder.mapper.ReminderMapper;
import com.example.reminder.util.PowerjobApiUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


/**
* @author liushizhan
* @description 针对表【reminder】的数据库操作Service实现
* @createDate 2024-10-01 13:29:15
*/
@Service
public class ReminderServiceImpl extends ServiceImpl<ReminderMapper, Reminder>
    implements ReminderService{

    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Override
    @Transactional
    public void addReminder(ReminderReq reminderReq) {
        // powerjob
//        HashMap<String, Object> jobParams = new HashMap<>();
//        jobParams.put("reminderInfo", reminderReq);
//        PowerjobApiUtil.addReminderJob(jobParams);
        
        Long jobId = null;
        // add db
        Reminder build = Reminder.builder()
                .reminderTime(reminderReq.getReminder_time())
                .cycle(reminderReq.getCycle())
                .beginDate(reminderReq.getBegin_date())
                .userId(reminderReq.getUser_id())
                .medicationId(reminderReq.getMedication_id())
                .build();
        this.save(build);

        // expire key
            // see redis
        BoundHashOperations<String, Object, Object> boundHashOps = redisTemplate.boundHashOps(DBConstant.REDIS_REMINDER_PREFIX + reminderReq.getUser_id());
        if(!boundHashOps.hasKey(reminderReq.getMedication_id())){
            // save to powerjob
            HashMap<String, Object> jobParams = new HashMap<>();
            jobParams.put("reminderInfo", reminderReq);
            jobId = PowerjobApiUtil.addReminderJob(jobParams);

        } else {
            // find earliestTime near two hour
            long earliestTime = Long.MAX_VALUE;
            long anHoursInMillis = 60 * 60 * 1000;
            for (Object key : boundHashOps.keys()) {
                MedicationReminderDTO medicationReminderDTO = JSON.parseObject((String) boundHashOps.get(key), MedicationReminderDTO.class);
                if(Math.abs(reminderReq.getReminder_time().getTime() - medicationReminderDTO.getReminder_time().getTime()) <= anHoursInMillis) {
                    earliestTime = Math.min(medicationReminderDTO.getReminder_time().getTime(), earliestTime);
                }
            }
            // before
            if(reminderReq.getReminder_time().getTime() < earliestTime){
                // exchange powerjob
            // later
            }
        }

        //save redis
        MedicationReminderDTO build1 = MedicationReminderDTO.builder()
                .reminder_time(reminderReq.getReminder_time())
                .cycle(reminderReq.getCycle())
                .begin_date(reminderReq.getBegin_date())
                .jobId(jobId)
                .build();
        String jsonString = JSON.toJSONString(build1);
        boundHashOps.put(reminderReq.getMedication_id(), jsonString);

    }
    @SuppressWarnings("unchecked")
    public static <T> T getProxy(T target) {
        Class<?> targetClass = target.getClass();

        return (T) Proxy.newProxyInstance(
                targetClass.getClassLoader(),
                targetClass.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Before method: " + method.getName());
                        Object result = method.invoke(target, args);
                        System.out.println("After method: " + method.getName());
                        return result;
                    }
                }
        );
    }
}




