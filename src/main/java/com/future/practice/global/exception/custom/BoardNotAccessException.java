package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class BoardNotAccessException extends CustomException {
    public BoardNotAccessException(ErrorCode errorCode) {
        super(ErrorCode.BOARD_NOT_ACCESS);
    }
}
