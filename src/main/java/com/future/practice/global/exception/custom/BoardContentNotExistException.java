package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class BoardContentNotExistException extends CustomException {
    public BoardContentNotExistException(ErrorCode errorCode) {
        super(ErrorCode.BOARD_CONTENT_NOT_EXIST);
    }
}
