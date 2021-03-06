package com.zale.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//可以返回状态码
@ResponseStatus(value= HttpStatus.FORBIDDEN,reason = "Too many Users...")
public class UserTooManyException extends RuntimeException {

    public UserTooManyException(){

    }
    public UserTooManyException(String message){
        super(message);
    }
}
