package com.mcancankaya.business;

import com.mcancankaya.dao.UserDao;
import com.mcancankaya.entity.User;

public class UserService {
    private final UserDao userDao = new UserDao();

    public User findByLogin(String email, String password) {
        return userDao.findByLogin(email, password);
    }
}
