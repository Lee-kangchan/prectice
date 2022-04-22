package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class LoginException extends CustomException{

    public LoginException(ErrorCode errorCode) {
        super(errorCode);
    }
}
