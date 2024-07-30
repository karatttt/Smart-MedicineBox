package com.example.medicine.service;

import com.example.medicine.common.PageBean;
import com.example.medicine.entity.UserEntity;

public interface UserService {
    PageBean getPageBean(Integer page, String name, Integer limit);

    void addUser(UserEntity user);

    void delete(Integer id);

    void updateUser(UserEntity user);
}
