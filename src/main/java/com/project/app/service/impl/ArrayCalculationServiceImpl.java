package com.project.app.service.impl;

import com.project.app.entity.DoubleArrayWrapper;
import com.project.app.exception.ArrayValidationException;
import com.project.app.service.ArrayCalculationService;

import java.util.OptionalDouble;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {

  @Override
  public OptionalDouble findMin(DoubleArrayWrapper array) throws ArrayValidationException {
    if (array == null) {
      return OptionalDouble.empty();
    }
    double min = array.getElement(0);
    for (int i = 1; i < array.size(); i++) {
      double current = array.getElement(i);
      if (Double.compare(current, min) < 0) {
        min = current;
      }
    }
    return OptionalDouble.of(min);
  }

  @Override
  public OptionalDouble findMax(DoubleArrayWrapper array) throws ArrayValidationException  {
    if (array == null) {
      return OptionalDouble.empty();
    }
    double max = array.getElement(0);
    for (int i = 1; i < array.size(); i++) {
      double current = array.getElement(i);
      if (Double.compare(current, max) > 0) {
        max = current;
      }
    }
    return OptionalDouble.of(max);
  }

  @Override
  public OptionalDouble calculateSum(DoubleArrayWrapper array) throws ArrayValidationException {
    if (array == null) {
      return OptionalDouble.empty();
    }
    double sum = 0.0;
    for (int i = 0; i < array.size(); i++) {
      sum = sum + array.getElement(i);
    }
    return OptionalDouble.of(sum);
  }

  @Override
  public OptionalDouble calculateAverage(DoubleArrayWrapper array) throws ArrayValidationException {
    if (array == null) {
      return OptionalDouble.empty();
    }
    OptionalDouble sum = calculateSum(array);
    if (sum.isPresent()) {
      double average = sum.getAsDouble() / array.size();
      return OptionalDouble.of(average);
    }
    return OptionalDouble.empty();
  }
}