package com.prueba.api.infrastructure.http;

import com.prueba.api.usecases.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userservice;

    @GetMapping("/getAll")
    public ResponseEntity getAllUsers(){

        /*List<User> listaTetst = new ArrayList<User>();
        User userTest = new User();
        userTest.setEmail("jiojojo");
        listaTetst.add(userTest);*/

        return new ResponseEntity<List>(userservice.getAllUsers(), HttpStatus.OK);
    }

}
