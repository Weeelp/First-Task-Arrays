package com.project.app.observer.impl;

import java.util.Arrays;

import com.project.app.entity.*;
import com.project.app.observer.ArrayObserver;
import com.project.app.warehouse.Warehouse;

public class ArrayObserverImpl implements ArrayObserver  {
  @Override
  public void handleEvent(AbstractArrayWrapper arr) {
    double[] elements = arr.getAll();

    double sum = Arrays.stream(elements).sum();
    double max = Arrays.stream(elements).max().orElse(0.0);
    double min = Arrays.stream(elements).min().orElse(0.0);
    double avg = Arrays.stream(elements).average().orElse(0.0);

    ArrayParameters params = new ArrayParameters(sum, avg, max, min);

    Warehouse.getInstance().put(arr.getId(), params);
  }
}
