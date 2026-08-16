package com.project.app.factory;

import com.project.app.entity.DoubleArrayWrapper;
import com.project.app.exception.ArrayValidationException;

public interface ArrayFactory {
  DoubleArrayWrapper create(double[] elements) throws ArrayValidationException;
}
