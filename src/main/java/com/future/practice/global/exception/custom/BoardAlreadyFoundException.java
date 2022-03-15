package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class BoardAlreadyFoundException extends CustomException{

    public BoardAlreadyFoundException() {
        super(ErrorCode.BOARD_ALREADY_FOUND);
    }
}
