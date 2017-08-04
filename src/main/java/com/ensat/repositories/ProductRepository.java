package com.ensat.repositories;

import com.ensat.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<User, Integer> {

}
