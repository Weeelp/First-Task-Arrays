package com.project.app.repository.specification.impl;

import com.project.app.entity.AbstractArrayWrapper;
import com.project.app.repository.specification.ArraySpecification;

public class SumGreaterThanSpecification implements ArraySpecification{
  private final double targetSum;

  public SumGreaterThanSpecification(double targetSum) {
    this.targetSum = targetSum;
  }

  @Override
  public boolean specify(AbstractArrayWrapper arr) {
    double sum = java.util.Arrays.stream(arr.getAll()).sum();
    return sum > targetSum;
  }
  
}
