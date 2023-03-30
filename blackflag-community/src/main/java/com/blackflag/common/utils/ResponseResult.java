package com.blackflag.common.utils;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;

/**
 * 响应数据
 * @author blackflagisme zhengclfy@qq.com
 */
public class ResponseResult<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 编码：0表示成功，其他值表示失败
     */
    @Schema(description = "编码：0表示成功，其他值表示失败")
    private int code = 0;
    /**
     * 消息内容
     */
    @Schema(description = "消息内容")
    private String msg = "success";
    /**
     * 响应数据
     */
    @Schema(description = "响应数据")
    private T data;

    public ResponseResult<T> ok(T data) {
        this.setData(data);
        return this;
    }

    public boolean success(){
        return code == 0;
    }

    public ResponseResult<T> error() {
        this.code = 500;
        this.msg = "服务器异常！";
        return this;
    }

    public ResponseResult<T> error(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public ResponseResult<T> error(String msg) {
        this.code = 500;
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
