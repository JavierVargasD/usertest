package com.techtest.api.domain.exceptions;

import com.techtest.api.domain.entity.Message;

public class InvalidEmailException extends CreationUserException{

    public Message getCustomMessage() {
        return new Message("Invalid email format");
    }
}
