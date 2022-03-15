package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class EmailAlreadyExistException extends CustomException{
    public EmailAlreadyExistException() {
        super(ErrorCode.EMAIL_ALREADY_EXIST);
    }
}
