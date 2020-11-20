package com.guiabolso.mock.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Data
public class ApiException {

    private HttpStatus httpStatus;
    private String message;
    private List<String> errors;

    public ApiException() {
        super();
    }

    public ApiException(HttpStatus httpStatus, String message, List<String> errors) {
        super();
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = errors;
    }

    public ApiException(HttpStatus httpStatus, String message, String error) {
        super();
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = Collections.singletonList(error);
    }
}
