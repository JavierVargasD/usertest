package com.techtest.api.infrastructure.http;

import com.techtest.api.domain.entity.Login;
import com.techtest.api.domain.entity.Message;
import com.techtest.api.domain.entity.TUser;
import com.techtest.api.domain.exceptions.CreationUserException;
import com.techtest.api.usecases.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userservice;

    @PostMapping("")
    public ResponseEntity create(@RequestBody TUser user){
        try {
            return new ResponseEntity<TUser>(userservice.createUser(user), HttpStatus.CREATED);
        } catch (CreationUserException e) {
            return new ResponseEntity<Message>(e.getCustomMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("")
    public ResponseEntity getAll(){
        return new ResponseEntity<List>(userservice.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable String id){
        Optional<TUser> optionalUser =  userservice.getUser(id);
        if(optionalUser.isEmpty()){
            return new ResponseEntity("User not found",HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(optionalUser.get(), HttpStatus.OK);
        }
    }

    @PutMapping("")
    public ResponseEntity updateUser(@RequestBody TUser user){
        return new ResponseEntity<TUser>(userservice.updateUser(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Login login){
        Boolean loginSuccesful = userservice.login(login);
        if(loginSuccesful){
            return new ResponseEntity("Login Succeded", HttpStatus.OK);
        } else {
            return new ResponseEntity("Failed Login", HttpStatus.UNAUTHORIZED);
        }
    }


}
