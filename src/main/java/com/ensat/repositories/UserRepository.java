package com.ensat.repositories;

import com.ensat.entities.User;
import com.ensat.services.UserService;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);

}
