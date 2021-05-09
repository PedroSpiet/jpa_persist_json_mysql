package com.example.json.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import java.util.Map;

@Slf4j
public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {


    @Override
    public String convertToDatabaseColumn(Map<String, Object> personInfo) {
        String personInfoJson = null;
        ObjectMapper objMapper = new ObjectMapper();
        try {
            personInfoJson =  objMapper.writeValueAsString(personInfo);
        } catch (JsonProcessingException e) {
            log.error("Erro ao converter de json para string");

            e.printStackTrace();
        }

        return personInfoJson;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String personInfoJson) {
        Map<String, Object> personInfo = null;
        ObjectMapper objMapper = new ObjectMapper();

        try {
            personInfo = objMapper.readValue(personInfoJson, Map.class);
        } catch (JsonProcessingException e) {
            log.error("Erro ao converter de string para json");
            e.printStackTrace();
        }

        return personInfo;
    }
}
