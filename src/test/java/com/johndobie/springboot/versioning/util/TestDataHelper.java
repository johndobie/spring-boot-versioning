package com.johndobie.springboot.versioning.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.johndobie.springboot.versioning.web.model.User;

public class TestDataHelper {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static User getUserDetails(Integer id) {
        return User
                .builder()
                .id(id)
                .age(50)
                .firstName("John")
                .lastName("Doe")
                .build();
    }

    public static String getJsonObjectAsString(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readJsonAsObject(String json, Class<T> targetClass) {
        try {
            return objectMapper.readValue(json, targetClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
