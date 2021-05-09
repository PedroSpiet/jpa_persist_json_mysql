package com.example.json.resources;

import com.example.json.model.Json;
import com.example.json.services.JsonService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/json")
public class JsonController {

    @Autowired
    JsonService service;

    @PostMapping
    public Json test(@RequestBody Json json) {
        return service.create(json);
    }

    @GetMapping
    public List<Json> find() {
        return service.find();
    }
}
