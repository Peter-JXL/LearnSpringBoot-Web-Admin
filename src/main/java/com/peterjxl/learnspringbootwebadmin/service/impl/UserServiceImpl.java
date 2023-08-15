package com.peterjxl.learnspringbootwebadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peterjxl.learnspringbootwebadmin.bean.User;
import com.peterjxl.learnspringbootwebadmin.mapper.UserMapper;
import com.peterjxl.learnspringbootwebadmin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
