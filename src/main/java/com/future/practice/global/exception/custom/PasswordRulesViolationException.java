package com.future.practice.global.exception.custom;

import com.future.practice.global.exception.ErrorCode;

public class PasswordRulesViolationException extends CustomException{
    public PasswordRulesViolationException() {
        super(ErrorCode.PASSWORD_RULES_VIOLATION);
    }
}
