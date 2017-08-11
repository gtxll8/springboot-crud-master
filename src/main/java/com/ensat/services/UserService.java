package com.ensat.services;

import com.ensat.entities.User;

public interface UserService {

    Iterable<User> listAllUsers();

    // Iterable<User> findByEmailAddress(String email);

    User getUserByID(Integer id);

    User saveUser(User user);

    User findByEmail(String email);

    boolean isUserExist(Integer id);

    Integer deleteUser(Integer id);

}
