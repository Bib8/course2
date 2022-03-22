package com.ashdicorse2.course2.Interfaces;

import com.ashdicorse2.course2.Data.Model.Question;

import java.util.Collection;

public interface ExaminService {
    Collection<Question> getQuestion(int amount);
}
