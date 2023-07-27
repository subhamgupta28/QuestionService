package com.subhamgupta.questionservice.mapper;


import com.subhamgupta.questionservice.model.Question;
import com.subhamgupta.questionservice.dto.QuestionDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class QuestionMapper implements Function<Question, QuestionDto> {

    @Override
    public QuestionDto apply(Question question) {
        return QuestionDto.builder()
                .id(question.getId())
                .option1(question.getOption1())
                .option2(question.getOption2())
                .option3(question.getOption3())
                .option4(question.getOption4())
                .questionTitle(question.getQuestionTitle())
                .build();
    }
}
