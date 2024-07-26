package com.example.smbdoctor.controller;

import com.example.smbcommom.util.Result;
import com.example.smbdoctor.service.EmotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmotionController {
    @Autowired
    EmotionService emotionService;

    @PostMapping("/emotion")
    public Result getEmotionData(String url){
        String data = emotionService.getEmotionData(url);
        return Result.success(data);
    }
}
