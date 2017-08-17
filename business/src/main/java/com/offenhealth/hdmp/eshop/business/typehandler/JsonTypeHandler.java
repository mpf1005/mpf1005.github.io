package com.offenhealth.hdmp.eshop.business.typehandler;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wenqiang.luo date:16/5/5
 */
@MappedTypes({JSONObject.class})
public class JsonTypeHandler<T> implements TypeHandler<T> {
    private Type type;

//    public JsonTypeHandler() {
//        type =  (Type)JSONObject.class;
//        //type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//    }

    public JsonTypeHandler(Class<T> clazz) {
        if (clazz == null)
            throw new IllegalArgumentException("Type argument cannot be null");
        this.type = (Type)clazz;
    }

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, T t, JdbcType jdbcType) throws SQLException {
        String json  = null;
        try
        {
            json = this.toJson(t);
        }
        catch (JsonProcessingException jpe) {
            throw new SQLException(jpe);
        }

        preparedStatement.setString(i, json);
    }

    @Override
    public T getResult(ResultSet resultSet, String s) throws SQLException {
        T object = null;
        try
        {
            object = this.fromJson(resultSet.getString(s));
        }
        catch (IOException ioe) {
            throw new SQLException(ioe);
        }

        return object;
    }

    @Override
    public T getResult(ResultSet resultSet, int i) throws SQLException {
        T object = null;
        try
        {
            object = this.fromJson(resultSet.getString(i));
        }
        catch (IOException ioe) {
            throw new SQLException(ioe);
        }

        return object;
    }

    @Override
    public T getResult(CallableStatement callableStatement, int i) throws SQLException {
        T object = null;
        try
        {
            object = this.fromJson(callableStatement.getString(i));
        }
        catch (IOException ioe) {
            throw new SQLException(ioe);
        }

        return object;
    }

    private T fromJson(String json) throws IOException {
        if (StringUtils.isBlank(json)) {
            return null;
        }

        return JsonUtils.getMapper().readValue(json, new GenericTypeReference(this.type));
    }

    private String toJson(T object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }

        return JsonUtils.getMapper().writeValueAsString(object);
    }


    private static class GenericTypeReference extends TypeReference<Void> {

        private Type type;

        public GenericTypeReference(Type type) {
            this.type = type;
        }

        @Override
        public Type getType() {
            return this.type;
        }
    }
}