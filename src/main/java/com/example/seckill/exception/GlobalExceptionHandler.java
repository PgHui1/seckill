package com.example.seckill.exception;

import com.example.seckill.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)

    public R ExceptionHandler(Exception e) {
        System.out.println("出大事了！！！！！！！！！！！");
        if (e instanceof GlobalException) {
            System.out.println("处理1");
            GlobalException ex = (GlobalException) e;
            return R.fail().message(ex.getMessage()).code(ex.code);
        } else if (e instanceof BindException) {
            System.out.println("处理2");
            BindException ex = (BindException) e;
            R respBean = R.fail();
            respBean.message("参数校验异常：" +
                    ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return respBean;
        }
        System.out.println("处理3");
        return R.fail().message("手机号码格式错误2");
    }
}
