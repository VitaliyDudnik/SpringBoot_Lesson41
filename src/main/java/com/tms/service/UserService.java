package com.tms.service;

import com.tms.dao.UserDao;
import com.tms.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(User user) {
        userDao.save(user);
    }

    public boolean existsUserByUsername(String username) {
        return userDao.existsUserByUsername(username);
    }

    public boolean existsUserByPassword(String password) {
        return userDao.existsUserByPassword(password);
    }

    public User getUserByPassword(String password) {
        return userDao.getUserByPassword(password);
    }

}
