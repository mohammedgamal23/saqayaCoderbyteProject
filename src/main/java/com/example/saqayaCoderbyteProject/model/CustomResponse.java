package com.example.saqayaCoderbyteProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomResponse {
    private String id;
    private String token;
}
