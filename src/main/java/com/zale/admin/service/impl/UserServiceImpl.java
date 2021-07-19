package com.zale.admin.service.impl;

import com.zale.admin.bean.User;
import com.zale.admin.mapper.UserMapper;
import com.zale.admin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


}
