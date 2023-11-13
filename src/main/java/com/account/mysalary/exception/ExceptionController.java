package com.account.mysalary.exception;

import com.account.mysalary.common.util.HttpResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity ExceptionHandle(Exception e) {
        return new ResponseEntity(HttpResponseUtil.getFailedCode(e.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
