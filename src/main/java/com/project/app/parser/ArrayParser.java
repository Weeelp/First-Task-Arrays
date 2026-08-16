package com.project.app.parser;

import com.project.app.exception.ArrayValidationException;

public interface ArrayParser {
  double[] parse (String line) throws ArrayValidationException;
}
