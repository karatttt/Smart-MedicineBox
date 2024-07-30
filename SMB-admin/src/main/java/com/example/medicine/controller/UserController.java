package com.example.medicine.controller;

import com.example.medicine.common.PageBean;
import com.example.medicine.common.Result;
import com.example.medicine.entity.UserEntity;
import com.example.medicine.service.UserService;
import com.example.medicine.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/user/list")
    public Result list(String name, Integer page, Integer limit){
        //System.out.println(user);

        //List<User> users = userService.getUsers(page,name,limit);
        PageBean pageBean=userService.getPageBean(page,name,limit);
        return Result.success(pageBean);

    }

    @PostMapping("/user/add")
    public Result add(@RequestBody UserEntity user){
        userService.addUser(user);
        return Result.success();
    }

    @DeleteMapping("user/del/{id}")
    public Result delete(@PathVariable Integer id){
        userService.delete(id);
        return Result.success();
    }

    @PostMapping("user/edit/")
    public Result update(@RequestBody UserEntity user){
        userService.updateUser(user);
        return Result.success();
    }
}
