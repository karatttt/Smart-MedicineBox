package com.example.medicine.controller;


import com.example.medicine.common.PageBean;
import com.example.medicine.common.Result;
import com.example.medicine.entity.MedicationEntity;
import com.example.medicine.service.MedicationService;
import com.example.medicine.service.impl.MedicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class MedicationController {

    @Autowired
    MedicationService medicationService;


    @GetMapping("/medication/list")
    public Result list(String name, Integer page, Integer limit){
        //System.out.println(medication);

        //List<Medication> medications = medicationService.getMedications(page,name,limit);
        PageBean pageBean=medicationService.getPageBean(page,name,limit);
        return Result.success(pageBean);

    }

    @PostMapping("/medication/add")
    public Result add(@RequestBody MedicationEntity medication){
        medicationService.addMedication(medication);
        return Result.success();
    }

    @DeleteMapping("medication/del/{id}")
    public Result delete(@PathVariable Integer id){
        medicationService.delete(id);
        return Result.success();
    }

    @PostMapping("medication/edit/")
    public Result update(@RequestBody MedicationEntity medication){
        medicationService.updateMedication(medication);
        return Result.success();
    }

}
