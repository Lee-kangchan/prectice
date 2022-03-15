package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class UserPasswordWrongException extends CustomException{
    public UserPasswordWrongException() {
        super(ErrorCode.PASSWORD_WRONG);
    }
}
