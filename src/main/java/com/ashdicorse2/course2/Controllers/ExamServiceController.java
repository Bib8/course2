package com.ashdicorse2.course2.Controllers;

import com.ashdicorse2.course2.Data.ServiceImpl.ExaminerServiceImpl;
import com.ashdicorse2.course2.Data.Model.Question;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping
public class ExamServiceController {
    private final ExaminerServiceImpl examinerService;

    public ExamServiceController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestion(amount);
    }

}
