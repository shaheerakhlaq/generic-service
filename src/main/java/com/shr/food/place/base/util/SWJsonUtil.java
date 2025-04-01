package com.shr.food.place.base.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shr.food.place.base.exception.SWException;

/**
 * @author MSA
 * @version 1.0
 */

public class SWJsonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * Convert an object to its JSON string representation.
     *
     * @param object the object to serialize
     * @return the JSON string representation of the object
     */
    public static String writeValue(Object object) {
        if (object == null) {
            return null;
        }

        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            String errorMessage = "Failed to serialize object: " + object.getClass().getName();
            throw new SWException(1021, errorMessage, e);
        }
    }

    /**
     * Convert a JSON string to an object of the specified type.
     *
     * @param <T>       the type of the resulting object
     * @param content   the JSON string to deserialize
     * @param valueType the class of the resulting object
     * @return the deserialized object
     */
    public static <T> T readValue(String content, Class<T> valueType) {
        if (content == null || content.isEmpty()) {
            SWLoggerUtil.warn("Empty or null JSON content provided for deserialization.");
            return null;
        }

        try {
            return MAPPER.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            SWLoggerUtil.error("JSON parsing error for content: {}", content, e);
            return null;
        }
    }
}