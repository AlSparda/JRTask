package com.user.service;

import com.user.dao.UserDao;
import com.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by aleksandr.tarasyuk on 25.06.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao nameDao) {
        this.userDao = nameDao;
    }

    @Override
    @Transactional
    public void addUser(User name) {
        userDao.addUser(name);
    }

    @Override
    @Transactional
    public void updateUser(User name, Date date) {
        userDao.updateUser(name,date);
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> listUserd() {
        return userDao.listUsers();
    }

    @Override
    public List<User> findUsers(String type) {
        return userDao.findUsers(type);
    }

    @Override
    @Transactional
    public void fillUsers() {
        userDao.findUsers();
    }
}
