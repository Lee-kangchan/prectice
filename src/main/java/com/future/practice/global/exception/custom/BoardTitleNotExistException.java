package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class BoardTitleNotExistException extends CustomException{
    public BoardTitleNotExistException() {
        super(ErrorCode.BOARD_TITLE_NOT_EXIST);
    }
}
