package com.ashdicorse2.course2;

import com.ashdicorse2.course2.Data.ServiceImpl.ExaminerServiceImpl;
import com.ashdicorse2.course2.Data.ServiceImpl.JavaQuestionsServiceImpl;
import com.ashdicorse2.course2.Data.Model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static com.ashdicorse2.course2.QuestionTestConst.*;

@ExtendWith(MockitoExtension.class)
public class ExaminServiceTest {
    @Mock
    private ExaminerServiceImpl out;

    @InjectMocks
    private JavaQuestionsServiceImpl javaQuestionServiceImpl;

    Question questionActual_1 = new Question(QUESTION_1, ANSWER_1);
    Question questionActual_2 = new Question(QUESTION_2, ANSWER_2);
    Question questionActual_3 = new Question(QUESTION_3, ANSWER_3);
    Question questionActual_4 = new Question(QUESTION_4, ANSWER_4);

    @BeforeEach
    public void startNew() {
        Collection<Question> allQuestions = Set.of(questionActual_1, questionActual_2, questionActual_3, questionActual_4);
        when(out.getQuestion(6)).thenReturn(allQuestions);
    }


    @Test
    void shouldGetQuestionForExamTest() {
        when(javaQuestionServiceImpl.getRandomQuestion()).thenReturn(
                new Question(QUESTION_1, ANSWER_1),
                new Question(QUESTION_2, ANSWER_2),
                new Question(QUESTION_3, ANSWER_3),
                new Question(QUESTION_4, ANSWER_4));

        Collection<Question> actual = out.getQuestion(4);
        List<Question> expected = List.of(
                new Question(QUESTION_1, ANSWER_1),
                new Question(QUESTION_2, ANSWER_2),
                new Question(QUESTION_3, ANSWER_3),
                new Question(QUESTION_4, ANSWER_4));
        assertEquals(expected, actual);
    }

}
