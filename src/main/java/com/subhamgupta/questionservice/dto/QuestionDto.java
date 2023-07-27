package com.subhamgupta.questionservice.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class QuestionDto {
    private String questionTitle;
    private Integer id;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}

