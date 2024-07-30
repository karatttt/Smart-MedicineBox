package com.example.medicine.mapper;

import com.example.medicine.entity.MedicationEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MedicationMapper {

    @Select("select * from medication.medications ")
    List<MedicationEntity> selectMedications();
    @Select("select * from medication.medications where name = #{name}")
    List<MedicationEntity> selectMedicationByName(String name);

    @Insert("insert into medication.medications(name,code,description)"+
            "values (#{name},#{code},#{dosage},#{description})")
    void addMedication(MedicationEntity medication);
    //    @Delete("delete from webwork1.medication where name = #{name} and type = #{type} and location = #{location} and status = #{status} and date = #{date}")
//    void delete(Medication medication);
    @Delete("delete from medication.medications where id = #{id}")
    void deleteById(Integer id);
    @Update("update medication.medications SET name = #{name}, code = #{type}, description = #{description}\n" +
            "WHERE id = #{id}")
    void updateById(MedicationEntity medication);
}
