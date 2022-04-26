package com.reggie.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggie.entity.User;
import com.reggie.mapper.UserMapper;
import com.reggie.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class USerServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
