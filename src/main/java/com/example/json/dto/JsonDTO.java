package com.example.json.dto;

import com.example.json.model.Json;
import lombok.*;

import java.util.List;
import java.util.Map;


@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JsonDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private List<Integer> personAttributes;

}
