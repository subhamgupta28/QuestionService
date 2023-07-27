package com.subhamgupta.questionservice.service;


import com.subhamgupta.questionservice.dao.QuestionDao;
import com.subhamgupta.questionservice.dto.Response;
import com.subhamgupta.questionservice.mapper.QuestionMapper;
import com.subhamgupta.questionservice.model.Question;
import com.subhamgupta.questionservice.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionDao questionDao;
    private final QuestionMapper questionMapper;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }


    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Success";
    }

    public Object getQuestionsForQuiz(String category, Integer length) {
        return questionDao.findRandomQuestion(category, length);
    }

    public List<QuestionDto> getQuestion(List<Integer> questionIds) {
        return questionDao.findAllById(questionIds).stream().map(questionMapper).toList();
    }

    public Integer getScore(List<Response> responses) {
        AtomicInteger rightAnswers = new AtomicInteger();
        var questionIds = responses.stream().map(Response::getId).toList();
        var questions = questionDao.findAllById(questionIds);
        responses.forEach(response -> {
            var question = questions.stream().filter((t)-> Objects.equals(t.getId(), response.getId())).findFirst().orElseThrow();
            if (response.getResponse().equals(question.getCorrectAnswer()))
                rightAnswers.getAndIncrement();
        });

        return rightAnswers.get();
    }
}
