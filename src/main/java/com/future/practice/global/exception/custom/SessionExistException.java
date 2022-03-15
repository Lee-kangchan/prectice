package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class SessionExistException extends CustomException{
    public SessionExistException() {
        super(ErrorCode.SESSION_EXIST);
    }
}
