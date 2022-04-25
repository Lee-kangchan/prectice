package com.future.practice.global.exception;

import com.future.practice.global.exception.custom.BoardException;
import com.future.practice.global.exception.custom.CustomException;
import com.future.practice.global.exception.custom.LoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;

@Slf4j
@RestControllerAdvice(basePackages = "com.future.practice.domain.*")
public class ControllerExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("handleHttpRequestMethodNotSupportedException", e);

        final ErrorResponse response
                = ErrorResponse
                .create()
                .code(HttpStatus.METHOD_NOT_ALLOWED.value())
                .message(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }
    //CustomException을 상속받은 클래스가 예외를 발생 시킬 시, Catch하여 ErrorResponse를 반환한다.
    @ExceptionHandler( CustomException.class )
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.error("handleAllException", e);
        log.error("handler CustomerException");
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse response
                = ErrorResponse
                .create()
                .code(errorCode.getCode())
                .message(e.toString());

        log.info(response.toString());
        log.info(HttpStatus.resolve(errorCode.getCode()).toString());

        return new ResponseEntity<>(response, HttpStatus.resolve(errorCode.getCode()));
    }
    //CustomException을 상속받은 클래스가 예외를 발생 시킬 시, Catch하여 ErrorResponse를 반환한다.
    @ExceptionHandler( LoginException.class )
    protected ResponseEntity<ErrorResponse> handleLoginException(CustomException e) {
        log.error("handleAllException", e);
        log.error("handler CustomerException");
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse response
                = ErrorResponse
                .create()
                .code(errorCode.getCode())
                .message(e.toString());

        log.info(response.toString());
        log.info(HttpStatus.resolve(errorCode.getCode()).toString());

        return new ResponseEntity<>(response, HttpStatus.resolve(errorCode.getCode()));
    }
    //CustomException을 상속받은 클래스가 예외를 발생 시킬 시, Catch하여 ErrorResponse를 반환한다.
    @ExceptionHandler( BoardException.class )
    protected ResponseEntity<ErrorResponse> handleBoardException(CustomException e) {
        log.error("handleAllException", e);
        log.error("handler CustomerException");
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse response
                = ErrorResponse
                .create()
                .code(errorCode.getCode())
                .message(e.toString());

        log.info(response.toString());
        log.info(HttpStatus.resolve(errorCode.getCode()).toString());

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