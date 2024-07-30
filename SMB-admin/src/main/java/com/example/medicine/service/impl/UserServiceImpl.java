package com.example.medicine.service.impl;

import com.example.medicine.common.PageBean;
import com.example.medicine.entity.UserEntity;
import com.example.medicine.mapper.UserMapper;
import com.example.medicine.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    public List<UserEntity> getUserEntitys(Integer page, String name, Integer limit) {
        //设置分页参数
        PageHelper.startPage(page,limit);
        //获取sql语句，将sql语句自动分为select count（*） from以及limit两句
        List<UserEntity> userList;
        if(name != "") {
            userList = userMapper.selectUserEntityByName(name);
        }else{
            userList = userMapper.selectUserEntitys();
        }
        Page<UserEntity> p= (Page<UserEntity>) userList;
        //封装bean
        List<UserEntity> pageBean=p.getResult();
        return pageBean;

    }

    public void addUser(UserEntity user) {
        userMapper.addUserEntity(user);
    }

    public PageBean getPageBean(Integer page, String name, Integer limit) {
        //设置分页参数
        PageHelper.startPage(page,limit);
        //获取sql语句，将sql语句自动分为select count（*） from以及limit两句
        List<UserEntity> userList;
        if(name != "") {
            userList = userMapper.selectUserEntityByName(name);
        }else{
            userList = userMapper.selectUserEntitys();
        }
        Page<UserEntity> p= (Page<UserEntity>) userList;
        //封装bean
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    public void delete(Integer id) {
        userMapper.deleteById(id);
    }

    public void updateUser(UserEntity user) {
        userMapper.updateById(user);


    }
}
