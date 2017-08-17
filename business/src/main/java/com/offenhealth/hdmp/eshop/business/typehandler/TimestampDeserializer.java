package com.offenhealth.hdmp.eshop.business.typehandler;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * @author wenqiang.luo date:16/8/25
 */
public class TimestampDeserializer extends JsonDeserializer<Timestamp> {

    @Override
    public Timestamp deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        String timeText= jsonParser.getText();
        if (timeText == null || timeText.isEmpty()) {
            return null;
        }

        return Timestamp.valueOf(timeText);
    }

}