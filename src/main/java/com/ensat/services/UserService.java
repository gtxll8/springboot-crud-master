package com.ensat.services;

import com.ensat.entities.User;

public interface UserService {

    Iterable<User> listAllUsers();

    User getUserByID(Integer id);

    User saveUser(User user);

    void deleteUser(Integer id);

    boolean isUserExist(User user);
}
