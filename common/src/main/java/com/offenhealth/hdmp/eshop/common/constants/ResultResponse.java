package com.offenhealth.hdmp.eshop.common.constants;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * Created by earl on 2017/5/17.
 */
@ApiModel(value = "返回的响应属性",description = "无论成功或失败，一定会返回此响应信息" )
public class  ResultResponse  {

    @ApiModelProperty(notes = "状态，1为成功.不为1都是失败",dataType="int" )
    private Integer status;
    @ApiModelProperty(notes = "状态码",dataType="int" )
    private Integer code;
    @ApiModelProperty(notes = "响应文本，状态为成功的情况下使用",dataType="string" )
    private String message;
    @ApiModelProperty(notes = "响应数据",dataType="string" )
    private Object data;
    @ApiModelProperty(notes = "响应错误信息.当状态（status）不为成功时，错误信息就是次字段",dataType="string" )
    private String error;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
