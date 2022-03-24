package com.ashdicorse2.course2.Data.ServiceImpl;

import com.ashdicorse2.course2.Data.Model.Question;
import com.ashdicorse2.course2.Exeptions.InvalidExamGenerateException;
import com.ashdicorse2.course2.Interfaces.ExaminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class
ExaminerServiceImpl implements ExaminService {

    private static final Logger log = LoggerFactory.getLogger(ExaminerServiceImpl.class);

    private final JavaQuestionsServiceImpl javaQuestionsService;

    public ExaminerServiceImpl(JavaQuestionsServiceImpl javaQuestionsService) {

        this.javaQuestionsService = javaQuestionsService;
    }
    @Override
    public Collection<Question> getQuestion(int amount) {
        int size = javaQuestionsService.getSize();
        if (amount <= 0 || size < amount) {
            log.error("The amount must be positive and must be more than" + size);
            try {
                throw new InvalidExamGenerateException(amount, size);
            } catch (InvalidExamGenerateException e) {
                e.printStackTrace();
            }
        }

    Set<Question> questions = new HashSet<>();
            while (questions.size() < amount) {
            questions.add(javaQuestionsService.getRandomQuestion());
        }
            log.info("The following random questions were found", amount, size);
            return questions;
    }


}
