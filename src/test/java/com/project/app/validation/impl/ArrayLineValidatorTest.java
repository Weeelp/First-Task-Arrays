package com.project.app.validation.impl;

import com.project.app.validation.ArrayValidator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayLineValidatorTest {

    private final ArrayValidator validator = new ArrayLineValidatorImpl();

    @Test
    void shouldValidateCorrectLineWithComma() {
        // given
        String line = "1, 2, 3";

        // when
        List<String> errors = validator.validate(line);

        // then
        assertTrue(errors.isEmpty());
    }

    @Test
    void shouldReturnErrorForLineWithLetters() {
        // given
        String line = "1y1 21 32";

        // when
        List<String> errors = validator.validate(line);

        // then
        assertFalse(errors.isEmpty());
    }
}