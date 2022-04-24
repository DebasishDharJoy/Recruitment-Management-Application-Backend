package com.recruitmentmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User with this username not found in database !!");
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
