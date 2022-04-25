package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class CommentException extends CustomException {
    public CommentException(ErrorCode errorCode) {
        super(errorCode);
    }
}
