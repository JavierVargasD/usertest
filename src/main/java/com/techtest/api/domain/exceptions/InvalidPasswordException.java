package com.techtest.api.domain.exceptions;

public class InvalidPasswordException extends CreationUserException{
    @Override
    public String getMessage() {
        return "Invalid password format";
    }
}
