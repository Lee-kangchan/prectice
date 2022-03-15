package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class CommentNotAccessException extends CustomException{
    public CommentNotAccessException() {
        super(ErrorCode.COMMENT_NOT_ACCESS);
    }
}
