package com.techtest.api.domain.exceptions;

import com.techtest.api.domain.entity.Message;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InvalidPasswordException extends CreationUserException{

    public Message customMessage;

    public InvalidPasswordException(String customMessage) {
        this.customMessage = new Message(customMessage);
    }
}
