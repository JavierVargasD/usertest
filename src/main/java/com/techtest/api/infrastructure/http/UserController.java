package com.techtest.api.infrastructure.http;

import com.techtest.api.domain.TUser;
import com.techtest.api.usecases.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userservice;

    @PostMapping("/")
    public ResponseEntity<TUser> create(@RequestBody TUser user){
        System.out.println(user);
        return new ResponseEntity<TUser>(userservice.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll(){

        /*List<User> listaTetst = new ArrayList<User>();
        User userTest = new User();
        userTest.setEmail("jiojojo");
        listaTetst.add(userTest);*/

        return new ResponseEntity<List>(userservice.getAllUsers(), HttpStatus.OK);
    }

}
