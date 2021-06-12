package com.jornada.microsservico.seguranca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends BaseException {

    public static final int CODE = HttpStatus.NOT_FOUND.value();

    public NotFoundException(String msg, Throwable cause) {
        super(CODE, msg, cause);
    }

    public NotFoundException(String msg) {
        super(CODE, msg);
    }

}
