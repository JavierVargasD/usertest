package com.techtest.api.usecases;

import com.techtest.api.infrastructure.persistence.UserRepository;
import com.techtest.api.domain.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<TUser> getAllUsers(){
        return userRepository.findAll();
    }

    public TUser createUser(TUser user){
        return userRepository.save(user);
    }

}
