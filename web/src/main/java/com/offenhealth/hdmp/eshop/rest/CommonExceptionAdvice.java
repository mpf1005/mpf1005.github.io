package com.offenhealth.hdmp.eshop.rest;

import com.offenhealth.hdmp.eshop.common.constants.ResultResponse;
import com.offenhealth.hdmp.eshop.common.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.net.BindException;

/**
 * @author JE哥
 * @email 1272434821@qq.com
 * @description:全局异常处理
 */
@ControllerAdvice
@ResponseBody
public class CommonExceptionAdvice {

    private static Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultResponse handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        logger.error("缺少请求参数", e);
        ResultResponse rr = new ResultResponse();
        rr.setStatus(0);
        rr.setCode(400);
        rr.setMessage(e.getMessage());
        rr.setError("缺少请求参数");
        return rr;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        ResultResponse rr = new ResultResponse();
        rr.setStatus(0);
        rr.setCode(400);
        rr.setMessage(e.getMessage());
        rr.setError("参数解析失败");
        return rr;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error("参数验证失败", e);
        ResultResponse rr = new ResultResponse();
        rr.setStatus(0);
        rr.setCode(400);
        rr.setMessage(e.getMessage());
        rr.setError("参数验证失败");
        return rr;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ResultResponse handleBindException(BindException e) {
        logger.error("参数绑定失败", e);
        ResultResponse rr = new ResultResponse();
        rr.setStatus(0);
        rr.setCode(400);
        rr.setMessage(e.getMessage());
        rr.setError("参数绑定失败");
        return rr;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultResponse handleServiceException(ConstraintViolationException e) {
        logger.error("参数验证错误", e);
        ResultResponse rr = new ResultResponse();
        rr.setStatus(0);
        rr.setCode(400);
        rr.setMessage(e.getMessage());
        rr.setError("参数验证错误");
        return rr;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ResultResponse handleValidationException(ValidationException e) {
        logger.error("参数验证有误", e);
        ResultResponse rr = new ResultResponse();
        rr.setStatus(0);
        rr.setCode(400);
        rr.setMessage(e.getMessage());
        rr.setError("参数验证有误");
        return rr;
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法", e);
        ResultResponse rr = new ResultResponse();
        rr.setStatus(0);
        rr.setCode(405);
        rr.setMessage(e.getMessage());
        rr.setError("不支持当前请求方法");
        return rr;
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResultResponse handleHttpMediaTypeNotSupportedException(Exception e) {
        logger.error("不支持当前媒体类型", e);
        ResultResponse rr = new ResultResponse();
        rr.setStatus(0);
        rr.setCode(415);
        rr.setMessage(e.getMessage());
        rr.setError("不支持当前媒体类型");
        return rr;
    }

    /**
     * 500 - Internal Server Error
     */
    /*@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServiceException.class)
    public ResultResponse handleServiceException(ServiceException e) {
        logger.error("业务逻辑异常", e);
        ResultResponse rr = new ResultResponse();
        rr.setStatus(0);
        rr.setCode(415);
        rr.setMessage(e.getMessage());
        rr.setError("业务逻辑异常");
        return rr;
    }*/

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResultResponse handleException(Exception e) {
        logger.error("通用异常", e);
        ResultResponse rr = new ResultResponse();
        rr.setStatus(0);
        rr.setCode(500);
        rr.setMessage(e.getMessage());
        rr.setError("服务器错误");
        return rr;
    }

    /**
     * 操作数据库出现异常:名称重复，外键关联
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResultResponse handleException(DataIntegrityViolationException e) {
        logger.error("操作数据库出现异常:", e);
        ResultResponse rr = new ResultResponse();
        rr.setStatus(0);
        rr.setCode(500);
        rr.setMessage(e.getMessage());
        rr.setError("操作数据库出现异常");
        return rr;
    }
    /**
     * 自定义异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServiceException.class)
    public  ResultResponse customException(ServiceException e) {
        logger.error("自定义异常:", e);
        ResultResponse rr = new ResultResponse();
        rr.setStatus(0);
        rr.setCode(e.getErroCode());
        rr.setMessage(e.getMsg());
        rr.setError("自定义异常");
        return rr;
    }

}