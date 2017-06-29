package com.user.service;

import com.user.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by aleksandr.tarasyuk on 25.06.2017.
 */
public interface UserService {
    void addUser(User name);
    void updateUser(User name, Date date);
    void removeUser(Long id);
    User getUserById(Long id);
    List<User> listUserd();

    List<User> findUsers(String type);

    void fillUsers();
}
