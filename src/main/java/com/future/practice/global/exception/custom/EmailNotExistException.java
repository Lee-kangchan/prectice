package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class EmailNotExistException extends CustomException{

    public EmailNotExistException() {
        super(ErrorCode.EMAIL_NOT_EXIST);
    }
}
