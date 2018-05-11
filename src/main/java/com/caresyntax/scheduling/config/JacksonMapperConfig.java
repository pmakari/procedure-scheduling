package com.caresyntax.scheduling.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 *
 * Created by Parviz on 10.05.2018.
 */
public class JacksonMapperConfig {

    private JacksonMapperConfig() {

    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {

        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
