package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class BoardNotFoundException extends CustomException{

    public BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }
}
