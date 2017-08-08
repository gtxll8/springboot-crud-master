package com.ensat.services;

import com.ensat.entities.User;

public interface UserService {

    Iterable<User> listAllUsers();

    User getUserByID(Integer id);

    User saveUser(User user);

    boolean isUserExist(Integer id);

    Long count();

    Integer deleteUser(Integer id);

}
