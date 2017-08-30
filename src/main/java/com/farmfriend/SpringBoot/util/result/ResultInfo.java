package com.farmfriend.SpringBoot.util.result;

import java.io.Serializable;

/**
 * Created by xiemin on 2016/9/21.
 */

public class ResultInfo implements Serializable{
    private int errno;
    private String errmsg;
    private Object data;
    public ResultInfo() {
        this.errno = 0;
        data = "";
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
        this.data = null;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
//        if (errmsg == null) {
//            errmsg = "inter error";
//        }
        this.errmsg = errmsg;
        this.data = null;
    }
    

    public String toString() {
        return "errno: " + this.getErrno() + " data: " + this.getData() + " errmsg: " + this.getErrmsg();
    }
}
