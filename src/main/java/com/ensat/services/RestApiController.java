package com.ensat.services;

import com.ensat.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gcalinescu on 02/08/2017.
 */
@RestController
@RequestMapping("/api")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    UserService userService; //Service which will do all data retrieval/manipulation work

    // -------------------Retrieve All Users---------------------------------------------//

    @GetMapping(value = "/users", produces = "application/json")
    public Iterable<User> GetUsers(){
        return (List) userService.listAllUsers();
    }

    // --- test

    @RequestMapping(value = "/users/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findByEmail(@PathVariable("email") String email) {

        User user = userService.findByEmail(email);
        if (user == null) {
            return new ResponseEntity("No Customer found with this email " + email, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(user, HttpStatus.OK);
    }

    // -------------------Show a User-------------------------------------------
    @GetMapping(value = "/users/{id}", produces = "application/json")
    public ResponseEntity getUserID(@PathVariable("id") Integer id) {

        User user = userService.getUserByID(id);
        if (user == null) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(user, HttpStatus.OK);
    }
    // -------------------Create a User-------------------------------------------

    @PostMapping(value = "/user/new", consumes = "application/json")
    public ResponseEntity createUser(@RequestBody User user) {

        userService.saveUser(user);

        return new ResponseEntity(user, HttpStatus.OK);
    }

    // -------------------Delete a User-------------------------------------------
   @RequestMapping (value = "/users/delete/{id}", consumes = "application/json")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id) {

        if (userService.isUserExist(id)) {
            userService.deleteUser(id);
            return new ResponseEntity("User with ID = " + id + " was now deleted", HttpStatus.OK);
        }
        return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
    }




}


