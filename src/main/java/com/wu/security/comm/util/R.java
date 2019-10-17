package com.wu.security.comm.util;

import com.wu.security.comm.constant.BizErrorCode;
import com.wu.security.comm.constant.CommonConstants;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author Qwu
 */
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private int code = CommonConstants.SUCCESS;

    @Getter
    @Setter
    private String msg = "success";

    @Getter
    @Setter
    private T data;

    public R() {
        super();
    }

    /**
     * 处理成功，使用此构造
     *
     * @param data
     */
    public R(T data) {
        super();
        this.data = data;
    }

    /**
     * 处理失败，使用此构造
     *
     * @param code
     */
    public R (BizErrorCode code) {
        super();
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public R (T data,String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

}
