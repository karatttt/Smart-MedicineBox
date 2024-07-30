package com.example.medicine.service.impl;


import com.example.medicine.common.PageBean;
import com.example.medicine.entity.MedicationEntity;
import com.example.medicine.mapper.MedicationMapper;
import com.example.medicine.service.MedicationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl  implements  MedicationService{


    @Autowired
    MedicationMapper medicationMapper;

    public List<MedicationEntity> getMedications(Integer page, String name, Integer limit) {
        //设置分页参数
        PageHelper.startPage(page,limit);
        //获取sql语句，将sql语句自动分为select count（*） from以及limit两句
        List<MedicationEntity> medicationList;
        if(name != "") {
            medicationList = medicationMapper.selectMedicationByName(name);
        }else{
            medicationList = medicationMapper.selectMedications();
        }
        Page<MedicationEntity> p= (Page<MedicationEntity>) medicationList;
        //封装bean
        List<MedicationEntity> pageBean=p.getResult();
        return pageBean;

    }

    public void addMedication(MedicationEntity medication) {
        medicationMapper.addMedication(medication);
    }

    public PageBean getPageBean(Integer page, String name, Integer limit) {
        //设置分页参数
        PageHelper.startPage(page,limit);
        //获取sql语句，将sql语句自动分为select count（*） from以及limit两句
        List<MedicationEntity> medicationList;
        if(name != "") {
            medicationList = medicationMapper.selectMedicationByName(name);
        }else{
            medicationList = medicationMapper.selectMedications();
        }
        Page<MedicationEntity> p= (Page<MedicationEntity>) medicationList;
        //封装bean
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    public void delete(Integer id) {
        medicationMapper.deleteById(id);
    }

    public void updateMedication(MedicationEntity medication) {
        medicationMapper.updateById(medication);


    }
}
