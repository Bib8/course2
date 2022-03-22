package com.ashdicorse2.course2.Data.ServiceImpl;

import com.ashdicorse2.course2.Data.Model.Question;
import com.ashdicorse2.course2.Interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionsServiceImpl implements QuestionService {

    private static final Set<Question> questionStorage = new HashSet<>();
    private static Random random = new Random();

    @Override
    public boolean add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return questionStorage.add(newQuestion);
    }

    @Override
    public boolean remove(String question, String answer) {
        return questionStorage.remove(new Question(question, answer));
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questionStorage);
    }

    @Override
    public Question getRandomQuestion() {
        return List.copyOf(questionStorage).get(random.nextInt(questionStorage.size()));
    }

    @Override
    public int getSize() {
        return questionStorage.size();
    }

    @Override
    public boolean add(Question question) {
        return questionStorage.add(question);
    }

    @Override
    public boolean remove(Question question)  {
        return questionStorage.remove(question);
    }

    public void setRandom(Random random) {
            JavaQuestionsServiceImpl.random = random;
        }

}
