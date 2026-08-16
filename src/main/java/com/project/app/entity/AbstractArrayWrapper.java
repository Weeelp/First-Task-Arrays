package com.project.app.entity;

import com.project.app.exception.ArrayValidationException;

public abstract class AbstractArrayWrapper {
  private final long id;

  protected AbstractArrayWrapper(long idValue) throws ArrayValidationException {
    this.id = idValue;
  }

  public long getId() { return id; }
}
