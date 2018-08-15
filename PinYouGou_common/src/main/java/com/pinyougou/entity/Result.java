package com.pinyougou.entity;

import java.io.Serializable;

/**
 * @program: PinYouGou_Parent
 * @description: 执行结果
 * @author: LLL
 * @create: 2018-08-13 19:25
 **/
public class Result implements Serializable {
    private boolean success;
    private String message;

    public Result(boolean success,String message){
        super();

        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
