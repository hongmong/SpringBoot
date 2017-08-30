package com.farmfriend.SpringBoot.util.exception;

/**
 * Created by xiemin on 2016/9/29.
 */
public class MyException extends Exception {
    private int errCode = 13;

    public MyException(int errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
    }

    public MyException(String errMsg) {
        super(errMsg);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(int errCode, String message, Throwable cause) {
        super(message, cause);
        this.errCode = errCode;
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public int getErrCode() {
        return this.errCode;
    }
}
