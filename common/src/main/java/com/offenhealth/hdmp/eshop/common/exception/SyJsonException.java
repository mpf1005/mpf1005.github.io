package com.offenhealth.hdmp.eshop.common.exception;


import com.offenhealth.hdmp.eshop.common.constants.ResultCode;

/**
 * 自定义异常——json异常
 * Created by earl on 2017/3/25.
 */
public class SyJsonException extends SyException {

    private static final long serialVersionUID = 1L;

    public SyJsonException(Throwable cause) {
        super(ResultCode.JSON_ERROR.getCode(), cause);
    }

}
