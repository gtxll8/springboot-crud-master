package com.ensat.services;

import com.ensat.util.CustomErrorType;
import com.ensat.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> products = userService.listAllUsers();

        return new ResponseEntity<Iterable<User>>(products, HttpStatus.ACCEPTED);
    }

    // -------------------Create a User-------------------------------------------

    @PostMapping(value = "/user/create", consumes = "application/json")
    @ResponseBody
        public String add(@RequestBody User user) {
            return String.valueOf( userService.saveUser(user) );

    }
}


