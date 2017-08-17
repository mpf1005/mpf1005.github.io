package com.offenhealth.hdmp.eshop.business.typehandler;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.IOException;
import java.util.Date;

/**
 * @author wenqiang.luo date:16/8/25
 */
public class DateJsonSerializer extends JsonSerializer<Date> {

    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        jsonGenerator.writeString(date != null ?
                DateFormatUtils.format(date, DATE_PATTERN) : "null");
    }
}
