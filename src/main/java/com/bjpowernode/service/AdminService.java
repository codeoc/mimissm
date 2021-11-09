package com.bjpowernode.service;

import com.bjpowernode.pojo.Admin;

public interface AdminService {

    //完成登陆判断
    Admin login(String name,String pwd);
}
