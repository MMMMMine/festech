package com.festech.webapi.base.result;

import com.festech.webapi.base.constant.ErrorConstant;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResultDO<T> implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4227833010077730477L;

    /**
     * 是否成功，默认失败
     */
    private boolean success = false;

    /**
     * 返回消息
     */
    private String msg = ErrorConstant.OK.getMsg();

    /**
     * 返回CODE
     */
    private int code = ErrorConstant.OK.getCode();

    /**
     * 返回结果封装器
     */
    private T data;

}