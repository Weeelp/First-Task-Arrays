package com.project.app.parser.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.app.exception.ArrayValidationException;
import com.project.app.parser.ArrayParser;

public class ArrayLineParserImpl implements ArrayParser {
  private static final String SPLIT_REGEX = "[,;\\s\\-_/\\\\|]+";

  @Override
  public double[] parse(String line) throws ArrayValidationException {
    if (line.strip().isBlank()) {
      throw new ArrayValidationException("Parse: nothing to parse");
    }

    String[] tokens = line.strip().split(SPLIT_REGEX);

    List<Double> numbers = new ArrayList<>();
    for (String token : tokens) {
      if (token.isBlank()) {
        continue;
      }
       try {
        numbers.add(Double.parseDouble(token));
      } catch (NumberFormatException e) {
        throw new ArrayValidationException("Invalid number: " + token);
      }
    }

    if (numbers.isEmpty()) {
      throw new ArrayValidationException("No valid numbers found");
    }

    double[] result = new double[numbers.size()];
    for (int i = 0; i < numbers.size(); i++) {
      result[i] = numbers.get(i);
    }
    return result;
  }
  
}
