package com.example.json.resources;

import com.example.json.dto.JsonDTO;
import com.example.json.model.Json;
import com.example.json.services.JsonService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
    public JsonDTO test(@RequestBody JsonDTO jsonDTO) {
        Json create = service.create(jsonDTO);
        ModelMapper mp = new ModelMapper();
        return mp.map(create, JsonDTO.class);
    }

    @GetMapping
    public List<JsonDTO> find() {
        return service.find();
    }
}
