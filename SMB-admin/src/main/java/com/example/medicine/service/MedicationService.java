package com.example.medicine.service;

import com.example.medicine.common.PageBean;
import com.example.medicine.entity.MedicationEntity;

public interface MedicationService {

    PageBean getPageBean(Integer page, String name, Integer limit);

    void addMedication(MedicationEntity medication);

    void delete(Integer id);

    void updateMedication(MedicationEntity medication);
}
