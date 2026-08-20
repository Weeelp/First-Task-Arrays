package com.project.app.validator.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.app.validator.ArrayValidator;

public class ArrayLineValidatorImpl implements ArrayValidator {
  private static final String ALLOWED_CHARACTERS = "^[\\d.,;\\s\\-_/\\\\|]+$";

  @Override
  public List<String> validate(String line) {
    List<String> errors = new ArrayList<>();
    if (line == null) {
      errors.add("Line is null");
      return errors;
    }

    if (line.strip().isBlank()) {
      return errors;
    }

    if (!line.matches(ALLOWED_CHARACTERS)) {
      errors.add("Invalid characters in line: " + line);
    }

    return errors;
  }
  
}
