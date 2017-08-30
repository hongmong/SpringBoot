package com.farmfriend.SpringBoot.util.exception;


import com.farmfriend.SpringBoot.util.result.ConstError;
import com.farmfriend.SpringBoot.util.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiemin on 2017/5/31.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultInfo jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ResultInfo r = new ResultInfo();
        r.setErrmsg(e.getMessage());
        if (e instanceof MyException) {
            r.setErrno(((MyException) e).getErrCode());
        } else {
            r.setErrno(ConstError.INTER_ERROR);
        }
        logger.error("GlobalExceptionHandler", e);
        return r;
    }
}