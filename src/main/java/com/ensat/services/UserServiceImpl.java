package com.ensat.services;

import com.ensat.entities.User;
import com.ensat.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User service implement.
 */
@Service
public class UserServiceImpl implements UserService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<User> listAllUsers() {
        return productRepository.findAll();
    }

    @Override
    public User getUserByID(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public User saveUser(User user) {
        return productRepository.save( user );
    }

    @Override
    public void deleteUser(Integer id) {
        productRepository.delete(id);
    }

}
