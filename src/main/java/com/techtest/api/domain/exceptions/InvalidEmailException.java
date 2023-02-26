package com.techtest.api.domain.exceptions;

public class InvalidEmailException extends CreationUserException{
    @Override
    public String getMessage() {
        return "Invalid email format";
    }
}
