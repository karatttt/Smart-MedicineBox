package com.example.reminder.controller;

import com.example.reminder.domain.dto.ReminderReq;
import com.example.reminder.service.ReminderService;
import com.example.smbcommon.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("reminder")
public class ReminderController {

//    @GetMapping( "/signature")
//    public String get(HttpServletRequest request, String signature, String timestamp, String nonce, String echostr) {
//        if (request.getMethod().equalsIgnoreCase("get")) {//用来校验，一般会验证前端配置的token等，这里简化了代码。
//            return echostr;
//        }
//        return echostr;
//    }

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    ReminderService reminderService;
    @GetMapping( "/redis")
    public void testRedis(){
        redisTemplate.opsForValue().set("d","ds");
        Object o = redisTemplate.opsForValue().get("d");
        redisTemplate.opsForValue().set("name", "www", 5, TimeUnit.SECONDS);
        System.out.println(o);
    }

    @PostMapping("/addReminder")
    public Result addReminder(@RequestBody ReminderReq reminderReq){
        reminderService.addReminder(reminderReq);
        return null;
    }



    // update reminder

    // get reminderList of user

    // remove

}
