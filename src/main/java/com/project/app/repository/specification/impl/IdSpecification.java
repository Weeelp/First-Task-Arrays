package com.project.app.repository.specification.impl;

import com.project.app.entity.AbstractArrayWrapper;
import com.project.app.repository.specification.ArraySpecification;

public class IdSpecification implements ArraySpecification {
  private final int targetId;

  public IdSpecification(int targetId) {
    this.targetId = targetId;
  }

  @Override
  public boolean specify(AbstractArrayWrapper arr) {
    return arr.getId() == targetId;
  }
  
}
