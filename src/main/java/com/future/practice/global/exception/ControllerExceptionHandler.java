package com.future.practice.global.exception;

import com.future.practice.global.exception.custom.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.InvalidParameterException;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    //CustomException을 상속받은 클래스가 예외를 발생 시킬 시, Catch하여 ErrorResponse를 반환한다.
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.error("handleAllException", e);

        ErrorCode errorCode = e.getErrorCode();

        ErrorResponse response
                = ErrorResponse
                .create()
                .code(errorCode.getCode())
                .message(e.toString());

        return new ResponseEntity<>(response, HttpStatus.resolve(errorCode.getCode()));
    }

    //모든 예외를 핸들링하여 ErrorResponse 형식으로 반환한다.
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("handleException", e);

        ErrorResponse response
                = ErrorResponse
                .create()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.toString());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}