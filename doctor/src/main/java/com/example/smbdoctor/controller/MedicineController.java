package com.example.smbdoctor.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.smbcommom.util.Result;

import com.example.smbdoctor.entity.MedicationInfo;
import com.example.smbdoctor.service.MedicationInfoService;
import com.example.smbdoctor.service.impl.MedicationInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("doctor")
public class MedicineController {



    @Autowired
    MedicationInfoService medicationInfoService;

    @GetMapping("/list")
    public  Result list(){
        return Result.success("haha");
    }


    @PostMapping("/addMedication")
    public Result addMedication(@RequestBody MedicationInfo medicationInfo){

        medicationInfoService.addMedication(medicationInfo);
        return Result.success();
    }


    @GetMapping("/processImage")
    public Result processImage(String imageURL){
        String content = medicationInfoService.processImage(imageURL);
        return Result.success(content);
    }



}
