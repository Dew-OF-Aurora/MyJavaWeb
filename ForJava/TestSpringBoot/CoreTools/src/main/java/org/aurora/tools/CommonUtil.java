package org.aurora.tools;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class CommonUtil {
    public static <T> T getObject(String key, Map<?, ?> map, Class<T> returnType) {
        if (map.containsKey(key)) {
            Object value = map.get(key);
            if (value != null) {
                if (returnType.isInstance(value)) {
                    return returnType.cast(value);
                } else {
                    throw new IllegalArgumentException("Value is not of type " + returnType.getName());
                }
            }
        }
        return null;
    }

    public static <T> T getObject(String key, Map<?, ?> map, TypeReference<T> returnType) {
        if (map.containsKey(key)) {
            Object value = map.get(key);
            if (value != null) {
                try {
                    return new ObjectMapper().convertValue(value, returnType);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Value is not of type " + returnType.getType().getTypeName());
                }
            }
        }
        return null;
    }
}
