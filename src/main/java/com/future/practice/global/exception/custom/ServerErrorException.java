package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class ServerErrorException extends CustomException{
    public ServerErrorException() {
        super(ErrorCode.SERVER_ERROR);
    }
}
