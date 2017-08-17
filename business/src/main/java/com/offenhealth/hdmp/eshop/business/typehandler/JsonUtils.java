package com.offenhealth.hdmp.eshop.business.typehandler;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author wenqiang.luo date:16/5/5
 */
public final class JsonUtils {

    private static ObjectMapper DEFAULT_MAPPER = new ObjectMapper();

    static
    {
        DEFAULT_MAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        DEFAULT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        DEFAULT_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        DEFAULT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        //DEFAULT_MAPPER.configure(JsonParser.Feature.INTERN_FIELD_NAMES, true);
        //DEFAULT_MAPPER.configure(JsonParser.Feature.CANONICALIZE_FIELD_NAMES, true);
        //DEFAULT_MAPPER.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        SimpleModule module = new SimpleModule("DateTimeModule", Version.unknownVersion());
        module.addSerializer(Date.class, new DateJsonSerializer());
        module.addDeserializer(Date.class, new DateJsonDeserializer());
        module.addSerializer(Timestamp.class,new TimestampSerializer());
        module.addDeserializer(Timestamp.class,new TimestampDeserializer());
        DEFAULT_MAPPER.registerModule(module);
    }

    private JsonUtils() { }

    public static ObjectMapper getMapper() {
        return DEFAULT_MAPPER;
    }
}