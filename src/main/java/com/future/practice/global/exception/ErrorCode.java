package com.future.practice.global.exception;

public enum ErrorCode {

    USER_NOT_EXIST(400, "입력한 유저가 존재하지 않습니다."),
    PASSWORD_WRONG(400, "비밀번호가 틀립니다."),
    SERVER_ERROR(500, "알 수 없는 오류입니다."),
    SESSION_NOT_EXIST(400, "로그인 되어 있지 않습니다."),
    SESSION_EXIST(400, "이미 로그인 되어 있습니다."),
    EMAIL_ALREADY_EXIST (400, "이미 해당 이메일이 존재합니다."),
    PASSWORD_RULES_VIOLATION (400, "비밀번호 8자리와 영문 숫자를 섞어주세요"),
    USER_ALREADY_EXIST(400, "유저가 이미 존재합니다."),
    BOARD_TITLE_NOT_EXIST(400, "제목이 존재하지 않습니다."),
    BOARD_CONTENT_NOT_EXIST(400, "게시물 내용이 존재하지 않습니다."),
    BOARD_NOT_ACCESS(403,"게시물 권한이 없습니다."),
    BOARD_NOT_FOUND(400, "게시물이 존재하지 않습니다."),
    BOARD_ALREADY_FOUND(400, "게시물이 이미 존재합니다."),
    COMMENT_NOT_FOUND(400, "댓글이 존재하지 않습니다."),
    COMMENT_NOT_ACCESS(400, "댓글에 권한이 없습니다.");

    private final int code;
    private final String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    ErrorCode(final int code, final String message) {
        this.message = message;
        this.code = code;
    }
}