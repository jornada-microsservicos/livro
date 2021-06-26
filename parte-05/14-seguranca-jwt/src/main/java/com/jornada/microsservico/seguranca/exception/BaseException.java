package com.jornada.microsservico.seguranca.exception;

public class BaseException extends Exception {
    private int code;

    public BaseException(int code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public BaseException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
