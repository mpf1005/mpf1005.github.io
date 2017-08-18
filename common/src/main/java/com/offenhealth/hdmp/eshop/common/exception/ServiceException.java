package com.offenhealth.hdmp.eshop.common.exception;

/**
 * @author JE哥
 * @email 1272434821@qq.com
 * @description:自定义异常类
 */
public class ServiceException extends RuntimeException {
  private  int erroCode;
  private  String msg;
  public ServiceException(String msg) {
    super(msg);
  }

  public ServiceException(String msg, int erroCode) {
    this.msg=msg;
    this.erroCode = erroCode;
  }

  public int getErroCode() {
    return erroCode;
  }

  public void setErroCode(int erroCode) {
    this.erroCode = erroCode;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

}
