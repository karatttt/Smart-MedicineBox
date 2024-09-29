package com.example.smbdoctor.service;

import com.example.smbdoctor.entity.MedicationInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liushizhan
* @description 针对表【medication_info】的数据库操作Service
* @createDate 2024-06-08 11:20:07
*/
public interface MedicationInfoService extends IService<MedicationInfo> {

    void addMedication(MedicationInfo medicationInfo);

    String processImage(String imageURL);
}
