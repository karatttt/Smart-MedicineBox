package com.example.medicine.mapper;

import com.example.medicine.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from medication.users ")
    List<UserEntity> selectUserEntitys();
    @Select("select * from medication.users where name = #{name}")
    List<UserEntity> selectUserEntityByName(String name);

    @Insert("insert into medication.users(name,gender,age,create_time)"+
            "values (#{name},#{gender},#{age},#{created_at})")
    void addUserEntity(UserEntity users);
    //    @Delete("delete from medication.users where name = #{name} and age = #{age} and addr = #{addr} and sex = #{sex} and birth = #{birth}")
//    void delete(UserEntity users);
    @Delete("delete from medication.users where id = #{id}")
    void deleteById(Integer id);
    @Update("update medication.users SET name = #{name}, age = #{age},  gender = #{gender}, create_time = #{created_at}\n" +
            "WHERE id = #{id}")
    void updateById(UserEntity users);
}
