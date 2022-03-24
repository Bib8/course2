package com.ashdicorse2.course2.Interfaces;

import com.ashdicorse2.course2.Data.Model.Question;

import java.util.Collection;

public interface QuestionService {
    boolean add(String question, String answer);
    boolean remove(String question, String answer);
    Collection<Question> getAll();
    Question getRandomQuestion();
    int getSize();
    boolean add(Question question);
    boolean remove(Question question);
}
