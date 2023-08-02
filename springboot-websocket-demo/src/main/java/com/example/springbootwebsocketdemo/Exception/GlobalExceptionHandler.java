package com.example.springbootwebsocketdemo.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

/**
 * @Description 全局异常处理类
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理运行时异常
     * @param ex
     * @param hm
     */
    public void handlerError(RuntimeException ex, HandlerMethod hm){
        log.info("运行时统一异常处理, 异常信息: {}, 异常类: {}, 异常方法: {}", ex.getMessage(), hm.getBean().getClass(), hm.getMethod().getName());
    }

    /**
     * 处理实体字段校验不通过异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        //从异常对象中拿到ObjectError对象
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        //然后提取错误提示信息进行返回
        return error.getDefaultMessage();
    }

    /**
     * 处理自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public String BusinessExceptionHandler(BusinessException e){
        //然后提取错误提示信息进行返回
        return e.getMessage();
    }
}
