package com.project.app.service;

import com.project.app.entity.DoubleArrayWrapper;

public interface ArraySortService {
  double[] sortMerge(DoubleArrayWrapper arr);
  double[] sortSelection(DoubleArrayWrapper arr);
}
