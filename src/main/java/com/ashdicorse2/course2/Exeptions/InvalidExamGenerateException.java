package com.ashdicorse2.course2.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidExamGenerateException extends IllegalArgumentException {

    public InvalidExamGenerateException(int amount, int size) {
        super(String.format("Failed to generate, actual size", amount, size));
    }
}
