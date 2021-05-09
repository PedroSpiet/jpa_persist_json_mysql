package com.example.json.model;

import com.example.json.util.HashMapConverter;
import lombok.*;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "JsonConverter")
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Json {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> personAttributes;


}
