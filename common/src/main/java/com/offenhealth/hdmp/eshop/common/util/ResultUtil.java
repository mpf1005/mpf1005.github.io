package com.offenhealth.hdmp.eshop.common.util;



import com.offenhealth.hdmp.eshop.common.constants.ResultCode;
import com.offenhealth.hdmp.eshop.common.constants.ResultResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * json返回工具
 * Created by earl on 2017/3/25.
 */
public final class ResultUtil {

    private ResultUtil(){}

    private static ResultResponse getErrorResponse(int code){
        ResultResponse result = new ResultResponse();
        result.setStatus(ResultCode.FAILURE.getCode());
        result.setCode(code);
        result.setError(ResultCode.getMessage(code));
        return result;
    }

    public static ResultResponse getError() {
        return getError(ResultCode.OP_ERROR.getCode());
    }


    public static ResultResponse getError(int code) {
        return getErrorResponse(code);
    }


    public static ResultResponse getError(int code, String message) {
        ResultResponse result = getErrorResponse(code);
        result.setError(message);
        return result;
    }

    public static ResultResponse getError(int code, String key, Object value) {
        ResultResponse result = getErrorResponse(code);
        Map<String, Object> map = new HashMap< >();
        map.put(key, value);
        result.setData(map);
        return result;
    }

    public static ResultResponse getError(int code, String[] keys, Object... values) {
        ResultResponse result = getErrorResponse(code);
        Map<String, Object> map = new HashMap< >();
        if (values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                map.put(keys[i], values[i]);
            }
        }
        result.setData(map);
        return result;
    }


    private static ResultResponse getSuccessResponse(){
        ResultResponse result = new ResultResponse();
        int successCode  =  ResultCode.SUCCESS_CODE.getCode();
        result.setStatus(ResultCode.SUCCESS.getCode());
        result.setCode(successCode );
        result.setMessage( ResultCode.getMessage(successCode));
        return result;
    }

    public static ResultResponse getSuccess() {
        return getSuccessResponse();
    }

    public static ResultResponse getSuccess(Object response){
        ResultResponse result = getSuccessResponse();
        result.setData(response);
        return result;
    }

    public static ResultResponse getSuccess(String key, Object value) {
        ResultResponse result = getSuccessResponse();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(key, value);
        result.setData(map);
        return result;
    }

    public static ResultResponse getSuccess(String[] keys, Object... values) {
        ResultResponse result = getSuccessResponse();
        Map<String, Object> map = new HashMap<String, Object>();
        if (values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                map.put(keys[i], values[i]);
            }
        }
        result.setData(map);
        return result;
    }

}
