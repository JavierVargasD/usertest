package com.techtest.api.domain.exceptions;

import com.techtest.api.domain.entity.Message;

public class InvalidPasswordException extends CreationUserException{

    public Message getCustomMessage() {
        return new Message("Invalid Password format");
    }
}
