package com.example.json.services;

import com.example.json.model.Json;
import com.example.json.repositories.JsonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class JsonService {
    @Autowired
    JsonRepository repo;

    public Json create(Json json) {
        return repo.save(json);
    }

    public List<Json> find() {
        return repo.findAll();
    }
}
