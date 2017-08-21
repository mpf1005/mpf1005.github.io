package com.offenhealth.hdmp.eshop.common.constants;

/**
 * 状态码
 * Created by earl on 2017/3/25.
 */
public enum ResultCode {

    // ------------------------固定状态码------------------------------------
     FAILURE(0, "失败") ,SUCCESS(1, "成功") ,
    SUCCESS_CODE(200, "服务器正常"),UN_KNOW_EXCEPTION(500, "未知异常") ,
    CLIENT_ERROR(400, "数据格式错误") , PARAM_ERROR(401, "参数错误") ,
    NO_PERMISSIONS(403, "无权限进行此操作!") , OP_ERROR(501, "操作失败，请重试") ,
    JSON_ERROR(502, "Json操作错误,请检查数据格式") , JDBC_ERROR(503, "数据库操作错误") ,
    DATA_ASSOCIATION(504, "操作失败,数据存在关联关系") ,DATA_NOT_EXIST(505, "操作失败,记录不存在") ,
    ILLEGAL_OPERATING(506, "操作失败,用户非法操作") ,WECHAT_ERROR(507, "操作失败，对接微信配置发生错误") ,
    UNKNOWN_ERROR(508, "未知错误") ,
    //-----------------------用户相关，状态码1000~1200 -----------------------------------

    ACCOUNT_CREATE_FAIL(1000, "用户创建失败") , ACCOUNT_LONG_ERROR(1001, "用户名或密码错误") ,
    ACCOUNT_PWD_ERROR(1002, "密码与确认密码不一致") ,ACCOUNT_NAME_EMPTY(1003, "用户名不能为空") ,
    ACCOUNT_TYPE_ERROR(1004, "用户类型错误") ,ACCOUNT_UPDATE_FAIL(1005, "用户修改失败") ,
    ACCOUNT_TRY_TOO_MORE(1006, "登录尝试次数过多，请10分钟后重试") ,ACCOUNT_LOCKED(1007, "账号被锁定") ,
    ACCOUNT_NOT_OPEN(1008, "未开放登录的用户") ,CAPTCHA_ERROR(1009, "验证码错误."),
    //-----------------------其他1300~~~~ -----------------------------------
    REGISTER_MODIFY_REPEAT(1300, "报名申请修改信息重复提交."),

    // ---------------------自定义状态信息---------------------------
    NO_GROUP_BY_ID(10001,"分组不存在"),
    NAME_CANNOT_BE_EMPTY(10002,"name不能为空");





    private int code;
    private String msg;

    ResultCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static String  getMessage(int code){
        for (ResultCode temp : ResultCode.values()) {
            if ( temp.code == code) {
                return temp.getMsg();
            }
        }
        return null;
    }


}
