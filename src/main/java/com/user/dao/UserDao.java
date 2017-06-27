package com.user.dao;

import com.user.model.User;

import java.util.List;

/**
 * Created by aleksandr.tarasyuk on 25.06.2017.
 */
public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(Long id);
    User getUserById(Long id);
    List<User> listUsers();

    List<User> filteredUsers(String type);

    void fillUsers();
}
