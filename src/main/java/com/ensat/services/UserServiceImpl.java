package com.ensat.services;

import com.ensat.entities.User;
import com.ensat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User service implement.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // public Iterable<User> findByEmailAddress(String email) {return userRepository.findByEmailAddress(email);}

    public Iterable<User> listAllUsers() {
        return userRepository.findAll();
    }


    public User getUserByID(Integer id) {
        return userRepository.findOne(id);
    }


    public User saveUser(User user) {
        return userRepository.save( user );
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public Integer deleteUser(Integer id) {
        userRepository.delete(id);
        return id;
    }


    public boolean isUserExist(Integer id) {
        if (getUserByID(id) == null){
            return false;
        }
        return true;
    }

}
