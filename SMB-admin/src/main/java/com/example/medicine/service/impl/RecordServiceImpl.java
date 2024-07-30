package com.example.medicine.service.impl;

import com.example.medicine.common.PageBean;
import com.example.medicine.entity.RecordEntity;
import com.example.medicine.mapper.MedicationMapper;
import com.example.medicine.mapper.RecordMapper;
import com.example.medicine.mapper.UserMapper;
import com.example.medicine.service.RecordService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordMapper recordMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    MedicationMapper medicationMapper;


    public List<RecordEntity> getRecordEntitys(Integer page, String name, Integer limit) {
        //设置分页参数
        PageHelper.startPage(page,limit);
        //获取sql语句，将sql语句自动分为select count（*） from以及limit两句
        List<RecordEntity> recordList;
        if(name != "") {
            recordList = recordMapper.selectRecordEntityByName(name);
        }else{
            recordList = recordMapper.selectRecordEntitys();
        }

        //medicationMapper.selectMedicationById(recordList)



        Page<RecordEntity> p= (Page<RecordEntity>) recordList;
        //封装bean
        List<RecordEntity> pageBean=p.getResult();
        return pageBean;

    }

    public void addRecord(RecordEntity record) {
        recordMapper.addRecordEntity(record);
    }

    public PageBean getPageBean(Integer page, Integer limit) {
        //设置分页参数
        PageHelper.startPage(page,limit);
        //获取sql语句，将sql语句自动分为select count（*） from以及limit两句
        List<RecordEntity> recordList;

        recordList = recordMapper.selectRecordEntitys();

        Page<RecordEntity> p= (Page<RecordEntity>) recordList;
        //封装bean
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    public void delete(Integer id) {
        recordMapper.deleteById(id);
    }

    public void updateRecord(RecordEntity record) {
        recordMapper.updateById(record);


    }
}
