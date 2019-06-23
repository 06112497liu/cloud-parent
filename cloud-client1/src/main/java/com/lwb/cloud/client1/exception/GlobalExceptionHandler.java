package com.lwb.cloud.client1.exception;

import com.lwb.cloud.client1.enums.ResponseStatus;
import com.lwb.cloud.client1.result.Result;
import com.lwb.cloud.client1.result.ResultUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

/**
 * @author liuweibo
 * @date 2019/6/23
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public Result ConstraintViolationExceptionHandler(ConstraintViolationException ex) {
        return
            ex.getConstraintViolations()
                .stream()
                .findFirst()
                .map(err -> ResultUtil.failForIllegalParam(
                    ResponseStatus.ILLEGAL_PARAM, err.getMessage()
                ))
                .orElse(ResultUtil.fail(ResponseStatus.UNKNOWN_EX));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        return
            ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(err -> ResultUtil.failForIllegalParam(
                    ResponseStatus.ILLEGAL_PARAM, err.getDefaultMessage()
                ))
                .orElse(ResultUtil.fail(ResponseStatus.UNKNOWN_EX));
    }

}
