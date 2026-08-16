package com.project.app.factory.impl;

import com.project.app.entity.DoubleArrayWrapper;
import com.project.app.exception.ArrayValidationException;
import com.project.app.factory.ArrayFactory;

public class DoubleArrayFactoryImpl implements ArrayFactory {
  private long idCounter;

  @Override 
  public DoubleArrayWrapper create(double[] elements) throws ArrayValidationException{
    idCounter++;
    return new DoubleArrayWrapper(idCounter, elements);
  }
}
