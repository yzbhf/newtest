package com.service;

import com.bean.User;
import com.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{
    @Resource(name="userMapper")
    private UserMapper userMapper;
    public User selectUser(User user) {

        return userMapper.selectUser(user);
    }

}
