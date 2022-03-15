package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class CommentNotFountException extends CustomException{
    public CommentNotFountException() {
        super(ErrorCode.COMMENT_NOT_FOUND);
    }
}
