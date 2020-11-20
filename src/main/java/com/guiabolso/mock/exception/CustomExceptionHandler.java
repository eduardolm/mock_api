package com.guiabolso.mock.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                                  final @NotNull HttpHeaders headers,
                                                                  final @NotNull HttpStatus status,
                                                                  final @NotNull WebRequest request) {
        logger.info(ex.getClass().getName());
        //
        final List<String> errors = new ArrayList<>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        final ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return handleExceptionInternal(ex, apiException, headers, apiException.getHttpStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(final HttpRequestMethodNotSupportedException ex,
                                                                         final @NotNull HttpHeaders headers,
                                                                         final @NotNull HttpStatus status,
                                                                         final @NotNull WebRequest request) {
        logger.info(ex.getClass().getName());
        //
        final StringBuilder builder = new StringBuilder();
        builder.append(ex.getMethod());
        builder.append(" method is not supported for this request. Supported methods are ");
        Objects.requireNonNull(ex.getSupportedHttpMethods()).forEach(t -> builder.append(t).append(" "));

        final ApiException apiException = new ApiException(HttpStatus.METHOD_NOT_ALLOWED, ex.getLocalizedMessage(),
                builder.toString());

        return new ResponseEntity<>(apiException, new HttpHeaders(), apiException.getHttpStatus());
    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex,
                                                                   final WebRequest request) {
        logger.info(ex.getClass().getName());
        //
        final String error = ex.getName() + " should be of type " + Objects.requireNonNull(ex.getRequiredType()).getName();

        final ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
        return new ResponseEntity<>(apiException, new HttpHeaders(), apiException.getHttpStatus());
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(final NullPointerException ex) {
        logger.info(ex.getClass().getName());

        final String error = ex.getMessage() + "TESTE";

        final ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
        return new ResponseEntity<>(apiException, new HttpHeaders(), apiException.getHttpStatus());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolationException(final ConstraintViolationException ex) {
        logger.info(ex.getClass().getName());

        final String error = ex.getMessage();
        final ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST, ex.getMessage(), error);
        return new ResponseEntity<>(apiException, new HttpHeaders(), apiException.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(final NoHandlerFoundException ex,
                                                                   final @NotNull HttpHeaders headers,
                                                                   final @NotNull HttpStatus status,
                                                                   final @NotNull WebRequest request) {
        logger.info(ex.getClass().getName());
        //
        final String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();

        final ApiException apiException = new ApiException(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), error);
        return new ResponseEntity<>(apiException, new HttpHeaders(), apiException.getHttpStatus());
    }
}
