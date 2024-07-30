package com.example.medicine.mapper;

import com.example.medicine.entity.RecordEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RecordMapper {
    @Select("select * from medication.medication_records ")
    List<RecordEntity> selectRecordEntitys();
    @Select("select * from medication.medication_records ")
    List<RecordEntity> selectRecordEntityByName(String name);

    @Insert("insert into medication.medication_records(medication_name,user_name,reminder_time,dosage,status)"+
            "values (#{medicationId},#{userId},#{reminderTime},#{dosage},#{status})")
    void addRecordEntity(RecordEntity records);
    //    @Delete("delete from medication.records where name = #{name} and age = #{age} and addr = #{addr} and sex = #{sex} and birth = #{birth}")
//    void delete(RecordEntity records);
    @Delete("delete from medication.medication_records where id = #{id}")
    void deleteById(Integer id);
    @Update("update medication.medication_records SET medication_name = #{medicationId}, user_name = #{userId},  reminder_time = #{reminderTime}, dosage = #{dosage},status = #{status}\n" +
            "WHERE id = #{id}")
    void updateById(RecordEntity records);
}
