package com.example;

import org.springframework.stereotype.Service;

/**
 * @author: Milogenius
 * @create: 2019-07-08 11:21
 * @description:
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public boolean checkUser(String loginName, String passWord) {
        return true;
    }

    @Override
    public User getUser(String loginName) {
        User user = new User();
        user.setName("李四");
        user.setPassword("123");
        return user;
    }
}
