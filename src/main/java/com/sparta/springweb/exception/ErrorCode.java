package com.sparta.springweb.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    // 404 Not Found
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "404", "유저를 찾을 수 없습니다. 로그인을 다시 해주세요."),
    NOT_FOUND_POST(HttpStatus.NOT_FOUND, "404", "해당 물건이 존재하지 않습니다."),
    NOT_FOUND_ITEM(HttpStatus.NOT_FOUND, "404", "장바구니에 물건이 존재하지 않습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;

    ErrorCode(HttpStatus httpStatus, String errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}