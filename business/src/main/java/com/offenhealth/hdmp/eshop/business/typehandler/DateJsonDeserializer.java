package com.offenhealth.hdmp.eshop.business.typehandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * @author wenqiang.luo date:16/8/25
 */
public class DateJsonDeserializer extends JsonDeserializer<Date> {

    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        String dateText = jsonParser.getText();
        if (dateText == null || dateText.isEmpty()) {
            return null;
        }

        try {
            return DateUtils.parseDate(dateText, DATE_PATTERN);
        } catch (ParseException pe) {
            throw new JsonParseException("Can not parse date string [" + dateText + "]",
                    jsonParser.getCurrentLocation(), pe);
        }
    }
}
