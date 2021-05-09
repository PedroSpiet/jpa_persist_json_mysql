package com.example.json.repositories;

import com.example.json.model.Json;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JsonRepository extends JpaRepository<Json, Long> {
}
