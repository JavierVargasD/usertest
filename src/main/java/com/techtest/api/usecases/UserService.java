package com.prueba.api.usecases;

import com.prueba.api.infrastructure.persistence.UserRepository;
import com.prueba.api.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
