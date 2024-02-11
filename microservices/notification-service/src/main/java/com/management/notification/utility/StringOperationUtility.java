package com.management.notification.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class StringOperationUtility {

    public static String convertToJson(Object object) throws JsonProcessingException {

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        // convert object to json
        String result = om.writerWithDefaultPrettyPrinter().writeValueAsString(object);

        return result;
    }
}
