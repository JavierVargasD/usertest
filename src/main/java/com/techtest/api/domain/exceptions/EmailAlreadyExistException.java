package com.techtest.api.domain.exceptions;

public class EmailAlreadyExistException extends CreationUserException{
    @Override
    public String getMessage() {
        return "Email already exits";
    }
}
