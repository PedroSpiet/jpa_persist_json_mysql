package com.example.json.services;

import com.example.json.dto.JsonDTO;
import com.example.json.model.Json;
import com.example.json.repositories.JsonRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class JsonService {
    @Autowired
    JsonRepository repo;

    public Json create(JsonDTO jsonDTO) {
        ModelMapper mp = new ModelMapper();
        Json json = mp.map(jsonDTO, Json.class);
        return repo.save(json);
    }

    public List<JsonDTO> find() {
        var json =  repo.findAll();
        ModelMapper mp = new ModelMapper();

        return mp.map(json, List.class);
    }
}
