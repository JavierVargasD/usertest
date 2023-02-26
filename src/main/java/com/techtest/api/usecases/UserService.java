package com.techtest.api.usecases;

import com.techtest.api.domain.entity.Login;
import com.techtest.api.domain.exceptions.CreationUserException;
import com.techtest.api.domain.exceptions.EmailAlreadyExistException;
import com.techtest.api.domain.exceptions.InvalidEmailException;
import com.techtest.api.domain.exceptions.InvalidPasswordException;
import com.techtest.api.infrastructure.persistence.UserRepository;
import com.techtest.api.domain.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<TUser> getAllUsers(){
        return userRepository.findAll();
    }

    public TUser createUser(TUser user) throws CreationUserException {
        long currentDateMillis = new java.util.Date().getTime();
        Date currentDate = new Date(currentDateMillis);
        user.setCreated(currentDate);
        user.setModified(currentDate);
        user.setLastLogin(currentDate);
        user.setActive(true);
        validateUser(user);
        return userRepository.save(user);
    }

    public TUser updateUser(TUser user){
        long currentDateMillis = new java.util.Date().getTime();
        Date currentDate = new Date(currentDateMillis);
        user.setModified(currentDate);
        return userRepository.save(user);
    }



    public boolean login(Login login){
        TUser tuser = findByEmail(login.getEmail());
        if(tuser != null && tuser.getPassword().equals(login.getPassword())){
            registerLogin(tuser);
            return true;
        } else {
            return false;
        }
    }

    private TUser registerLogin(TUser user){
        long currentDateMillis = new java.util.Date().getTime();
        Date currentDate = new Date(currentDateMillis);
        user.setLastLogin(currentDate);
        return userRepository.save(user);
    }

    public Optional<TUser> getUser(String id){
        return userRepository.findById(id);
    }

    private TUser findByEmail(String email){
        List<TUser> tusers =  userRepository.findByEmail(email);
        if(tusers.isEmpty()){
            return null;
        } else {
            return tusers.get(0);
        }
    }

    private void validateUser(TUser user) throws CreationUserException {
        if(emailExits(user.getEmail())){
            throw new EmailAlreadyExistException();
        }
        if(!validateEmail(user.getEmail())){
            throw new InvalidEmailException();
        }
        if(!validatePassword(user.getPassword())){
            throw new InvalidPasswordException();
        }
    }

    private boolean emailExits(String email){
        return findByEmail(email) != null;
    }

    private boolean validateEmail(String email){
        return email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    }

    private boolean validatePassword(String password){
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$");
    }
}
