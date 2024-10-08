package com.example.smbdoctor.controller;

import com.example.smbcommon.util.Result;

import com.example.smbdoctor.entity.MedicationInfo;
import com.example.smbdoctor.service.MedicationInfoService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("doctor")
public class MedicineController implements BeanFactoryPostProcessor {



    @Autowired
    MedicationInfoService medicationInfoService;

    @GetMapping( "/signature")
    public String get(HttpServletRequest request, String signature, String timestamp, String nonce, String echostr) {
        if (request.getMethod().equalsIgnoreCase("get")) {//用来校验，一般会验证前端配置的token等，这里简化了代码。
            return echostr;
        }
        return echostr;
    }
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


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        
    }
}
