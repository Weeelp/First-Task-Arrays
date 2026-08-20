package com.project.app.entity;

import com.project.app.exception.ArrayValidationException;
import com.project.app.observer.ArrayObserver;

public abstract class AbstractArrayWrapper {
  private final int id;
  private ArrayObserver observer;

  protected AbstractArrayWrapper(int idValue) throws ArrayValidationException {
    this.id = idValue;
  }

  public int getId() { return id; }

  public abstract double[] getAll();

  public void setObserver(ArrayObserver observer2) {
    this.observer = observer2;
  }

  public void notifyObserver() {
    if(observer != null) {
      observer.handleEvent(this);
    }
  }
}
