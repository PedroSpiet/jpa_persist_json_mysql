package com.example.json.util;

import com.example.json.model.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
public class HashMapConverter implements AttributeConverter<List<Integer>, String> {

    @Override
    public String convertToDatabaseColumn(List<Integer> attribute) {
        String teste = null;
        try {
            ObjectMapper obj = new ObjectMapper();
            teste = obj.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return teste;
    }

    @Override
    public List<Integer> convertToEntityAttribute(String dbData) {
        List<Integer> teste = null;
        try {
            ObjectMapper obj = new ObjectMapper();
            teste = obj.readValue(dbData, List.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return teste;
    }
}
