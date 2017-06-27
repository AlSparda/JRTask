package com.user.service;

import com.user.dao.UserDao;
import com.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void updateUser(User name) {
        userDao.updateUser(name);
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
    public List<User> filteredUsers(String type) {
        return userDao.filteredUsers(type);
    }

    @Override
    @Transactional
    public void fillUsers() {
        userDao.fillUsers();
    }
}
