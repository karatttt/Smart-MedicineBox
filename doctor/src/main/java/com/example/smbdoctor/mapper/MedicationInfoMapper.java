package com.example.smbdoctor.mapper;

import com.example.smbdoctor.entity.MedicationInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author liushizhan
* @description 针对表【medication_info】的数据库操作Mapper
* @createDate 2024-06-08 11:20:07
* @Entity com.example.smbdoctor.entity.MedicationInfo
*/

@Mapper
public interface MedicationInfoMapper extends BaseMapper<MedicationInfo> {

}




