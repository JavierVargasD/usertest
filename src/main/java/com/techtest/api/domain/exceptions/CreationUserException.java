package com.techtest.api.domain.exceptions;

import com.techtest.api.domain.entity.Message;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class CreationUserException extends Exception{

    public abstract Message getCustomMessage();

}
