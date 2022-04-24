package com.recruitmentmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserFoundException  extends  Exception{

    public UserFoundException() {
        super("User with this Username is already there in DB !! try with another one");
    }

    public UserFoundException(String msg)
    {
        super(msg);
    }
}