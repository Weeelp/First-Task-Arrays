package com.project.app.repository.specification.impl;

import com.project.app.entity.AbstractArrayWrapper;
import com.project.app.repository.specification.ArraySpecification;

public class AllElementsSpecification implements ArraySpecification {
  @Override
  public boolean specify(AbstractArrayWrapper arr) {
    return true;
  }
  
}
