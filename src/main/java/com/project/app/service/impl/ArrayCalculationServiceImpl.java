package com.project.app.service.impl;

import com.project.app.entity.DoubleArrayWrapper;
import com.project.app.service.ArrayCalculationService;

import java.util.Optional;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {

  @Override
  public Optional<Double> findMin(DoubleArrayWrapper array) {
    if (array == null) {
      return Optional.empty();
    }
    double min = array.getElement(0);
    for (int i = 1; i < array.size(); i++) {
      double current = array.getElement(i);
      if (Double.compare(current, min) < 0) {
        min = current;
      }
    }
    return Optional.of(min);
  }

  @Override
  public Optional<Double> findMax(DoubleArrayWrapper array) {
    if (array == null) {
      return Optional.empty();
    }
    double max = array.getElement(0);
    for (int i = 1; i < array.size(); i++) {
      double current = array.getElement(i);
      if (Double.compare(current, max) > 0) {
        max = current;
      }
    }
    return Optional.of(max);
  }

  @Override
  public Optional<Double> calculateSum(DoubleArrayWrapper array) {
    if (array == null) {
      return Optional.empty();
    }
    double sum = 0.0;
    for (int i = 0; i < array.size(); i++) {
      sum = sum + array.getElement(i);
    }
    return Optional.of(sum);
  }

  @Override
  public Optional<Double> calculateAverage(DoubleArrayWrapper array) {
    if (array == null) {
      return Optional.empty();
    }
    Optional<Double> sum = calculateSum(array);
    if (sum.isPresent()) {
      double average = sum.get() / array.size();
      return Optional.of(average);
    }
    return Optional.empty();
  }
}