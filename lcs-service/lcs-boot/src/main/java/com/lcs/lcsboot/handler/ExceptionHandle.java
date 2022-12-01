package com.lcs.lcsboot.handler;

import com.lcs.lcsboot.result.Result;
import com.lcs.lcsboot.result.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public Result hadndle(Exception e) {
        e.printStackTrace();
        return Result.failed(ResultCode.SYSTEM_EXECUTION_ERROR, e.getMessage());
    }

//    @ExceptionHandler(value = MyException.class)
//    public Result hadndle(MyException e) {
//        e.printStackTrace();
//        return    return Result.failed(ResultCode.SYSTEM_EXECUTION_ERROR, e.getMessage());
//    }

}