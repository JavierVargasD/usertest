package com.techtest.api.domain.exceptions;

import com.techtest.api.domain.entity.Message;

public class EmailAlreadyExistException extends CreationUserException{
    public Message getCustomMessage() {
        return new Message("Email already exists");
    }

}
