package com.example.medicine.service;

import com.example.medicine.common.PageBean;
import com.example.medicine.entity.RecordEntity;

public interface RecordService {
    PageBean getPageBean(Integer page, Integer limit);

    void addRecord(RecordEntity record);

    void delete(Integer id);

    void updateRecord(RecordEntity record);
}
