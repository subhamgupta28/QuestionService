package com.subhamgupta.questionservice.dao;

import com.subhamgupta.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query("""
            select q.id from Question q where q.category =:category order by random() limit :nums
            """)
    List<Integer> findRandomQuestion(String category, Integer nums);
}
