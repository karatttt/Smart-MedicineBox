package com.example.medicine.controller;

import com.example.medicine.common.PageBean;
import com.example.medicine.common.Result;
import com.example.medicine.entity.RecordEntity;
import com.example.medicine.service.MedicationService;
import com.example.medicine.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class RecordController {
    @Autowired
    RecordService recordService;
    @GetMapping("/record/list")
    public Result list(Integer page, Integer limit){
        //System.out.println(record);

        //List<Record> records = recordService.getRecords(page,name,limit);
        PageBean pageBean=recordService.getPageBean(page,limit);
        return Result.success(pageBean);

    }

    @PostMapping("/record/add")
    public Result add(@RequestBody RecordEntity record){
        recordService.addRecord(record);
        return Result.success();
    }

    @DeleteMapping("record/del/{id}")
    public Result delete(@PathVariable Integer id){
        recordService.delete(id);
        return Result.success();
    }

    @PostMapping("record/edit/")
    public Result update(@RequestBody RecordEntity record){
        recordService.updateRecord(record);
        return Result.success();
    }
}
