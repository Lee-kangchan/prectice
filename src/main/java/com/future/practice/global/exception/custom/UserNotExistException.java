package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class UserNotExistException extends CustomException{
    public UserNotExistException() {
        super(ErrorCode.USER_NOT_EXIST);
    }
}
