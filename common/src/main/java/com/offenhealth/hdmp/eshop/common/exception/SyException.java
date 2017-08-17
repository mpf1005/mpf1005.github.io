package com.offenhealth.hdmp.eshop.common.exception;


import com.offenhealth.hdmp.eshop.common.constants.ResultCode;

/**
 * 自定义异常
 * Created by earl on 2017/3/25.
 */
public class SyException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private int resultCode;

    public SyException(Throwable cause) {
        super(cause);
        this.resultCode = ResultCode.OP_ERROR.getCode();
    }

    public SyException(int resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }


    public SyException(int resultCode) {
        super(ResultCode.getMessage(resultCode));
        this.resultCode = resultCode;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getResultMessage() {
        return ResultCode.getMessage(resultCode);
    }

}
