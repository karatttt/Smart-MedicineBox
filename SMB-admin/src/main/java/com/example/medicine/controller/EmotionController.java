package com.example.medicine.controller;


import com.example.medicine.common.Result;
import com.example.medicine.service.EmotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class EmotionController {

    @Autowired
    EmotionService emotionService;
    @GetMapping("/getEmotionData")
    public Result getEmotionData(String imageURL){

        HashMap map = emotionService.getEmotionData(imageURL);
        return Result.success();

    }

}
