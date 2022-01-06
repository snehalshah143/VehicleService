package com.snehal.carservice.util;

import java.util.Set;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter
public class StringSetConverter<Order> implements AttributeConverter<Set<Order>, String> {
	static final ObjectMapper mapper = new ObjectMapper();

    public String convertToDatabaseColumn(Set<Order> list) {
        if (list == null)
            return null;
        try {
            return mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public Set<Order> convertToEntityAttribute(String dbJson) {
        if (dbJson == null)
            return null;
        try {
            return mapper.readValue(dbJson, new TypeReference<Set<Order>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}