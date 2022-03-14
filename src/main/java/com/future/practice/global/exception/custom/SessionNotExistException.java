package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class SessionNotExistException extends CustomException{
    public SessionNotExistException(ErrorCode errorCode) {
        super(ErrorCode.SESSION_NOT_EXIST);
    }
}
