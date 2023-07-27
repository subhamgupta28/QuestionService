package com.subhamgupta.questionservice.controller;

import com.subhamgupta.questionservice.dto.Response;
import com.subhamgupta.questionservice.model.Question;
import com.subhamgupta.questionservice.dto.QuestionDto;
import com.subhamgupta.questionservice.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/question")
@RequiredArgsConstructor
public class QuestionController {


    private final QuestionService questionService;
    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return ResponseEntity.ok(questionService.getQuestionsByCategory(category));
    }

    @PostMapping("/addQuestion")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @GetMapping("/generate")
    public ResponseEntity<?> getQuestionsForQuiz(
            @RequestParam String category,
            @RequestParam Integer length
    ){
        return ResponseEntity.ok(questionService.getQuestionsForQuiz(category, length));
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionDto>> getQuestions(
            @RequestBody List<Integer> questionIds
    ){
        return ResponseEntity.ok(questionService.getQuestion(questionIds));
    }

    @PostMapping("/getScore")
    public ResponseEntity<?> getScore(
            @RequestBody List<Response> responses
    ){
        return ResponseEntity.ok(questionService.getScore(responses));

    }
}
