package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class UserAlreadyExistException extends CustomException{
    public UserAlreadyExistException() {
        super(ErrorCode.USER_ALREADY_EXIST);
    }
}
