package com.peterjxl.learnspringbootwebadmin.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String handlerArithmeticException(Exception e) {
        log.error("异常是：{}", e);
        return "login";
    }
}
