package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class UserPasswordWrongException extends CustomException{
    public UserPasswordWrongException(ErrorCode errorCode) {
        super(ErrorCode.PASSWORD_WRONG);
    }
}
