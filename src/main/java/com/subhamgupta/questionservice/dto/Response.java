package com.subhamgupta.questionservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private Integer id;
    private String response;
}
