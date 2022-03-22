package com.ashdicorse2.course2;

import com.ashdicorse2.course2.Data.ServiceImpl.JavaQuestionsServiceImpl;
import com.ashdicorse2.course2.Data.Model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static com.ashdicorse2.course2.QuestionTestConst.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceImplTest {
    @Mock
    private JavaQuestionsServiceImpl service;

    @InjectMocks
    private JavaQuestionsServiceImpl out;



    @Test
    public void shouldAddQuestionTest() {
        Question question = new Question(QUESTION_1, ANSWER_1);
        assertTrue(out.add(question));
        assertFalse(out.add(question));
    }

    @Test
    public void shouldRemoveQuestionTest() {
        String questionTest = QUESTION_1;
        String answerTest = ANSWER_1;
        Question question = new Question(questionTest, answerTest);
        when(service.remove(question)).thenReturn(true, false);

        assertTrue(out.remove(questionTest, answerTest));
        assertFalse(out.remove(questionTest, answerTest));
    }

    @Test
    public void shouldGetAllQuestionTest() {
        Set<Question> questions = Set.of(
                new Question(QUESTION_1, ANSWER_1),
                new Question(QUESTION_2, ANSWER_2)
        );
        when(service.getAll()).thenReturn(questions);

        assertEquals(out.getAll().size(), questions.size());
        assertTrue(out.getAll().containsAll(questions));
    }

    @Test
    public void shouldReturnRandomQuestionTest() {
        when(service.getAll()).thenReturn(List.of(
                new Question(QUESTION_1, ANSWER_1),
                new Question(QUESTION_2, ANSWER_2),
                new Question(QUESTION_3, ANSWER_3)
        ));

        Random randomMock = mock(Random.class);
        when(randomMock.nextInt(anyInt())).thenReturn(0, 2);
        out.setRandom(randomMock);

        assertEquals(new Question(QUESTION_1, ANSWER_1), out.getRandomQuestion());
        assertEquals(new Question(QUESTION_2, ANSWER_2), out.getRandomQuestion());


    }
}
