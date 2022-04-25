package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class BoardException extends CustomException {

    public BoardException(ErrorCode errorCode) {
        super(errorCode);
    }
}
