package com.project.app.service.impl;

import com.project.app.entity.DoubleArrayWrapper;
import com.project.app.service.ArraySortService;

public class ArraySortServiceImpl implements ArraySortService {

  @Override
  public double[] sortMerge(DoubleArrayWrapper array) {
    if (array == null || array.size() == 0) {
      return new double[0];
    }
    double[] elements = array.toArray();
    mergeSort(elements, 0, elements.length - 1);
    return elements;
  }

  private void mergeSort(double[] arr, int left, int right) {
    if (left < right) {
      int center = left + (right - left) / 2;
      mergeSort(arr, left, center);
      mergeSort(arr, center + 1, right);
      merge(arr, left, center, right);
    }
  }

  private void merge(double[] arr, int left, int center, int right) {
    int leftSize = center - left + 1;
    int rightSize = right - center;

    double[] leftArr = new double[leftSize];
    double[] rightArr = new double[rightSize];

    for (int i = 0; i < leftSize; i++) {
      leftArr[i] = arr[left + i];
    }
    for (int j = 0; j < rightSize; j++) {
      rightArr[j] = arr[center + 1 + j];
    }

    int i = 0;
    int j = 0;
    int k = left;

    while (i < leftSize && j < rightSize) {
      if (Double.compare(leftArr[i], rightArr[j]) <= 0) {
        arr[k] = leftArr[i];
        i = i + 1;
      } else {
        arr[k] = rightArr[j];
        j = j + 1;
      }
      k = k + 1;
    }

    while (i < leftSize) {
      arr[k] = leftArr[i];
      i = i + 1;
      k = k + 1;
    }

    while (j < rightSize) {
      arr[k] = rightArr[j];
      j = j + 1;
      k = k + 1;
    }
  }

  @Override
  public double[] sortSelection(DoubleArrayWrapper array) {
    if (array == null || array.size() == 0) {
      return new double[0];
    }
    double[] elements = array.toArray();

    for (int i = 0; i < elements.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < elements.length; j++) {
        if (Double.compare(elements[j], elements[minIndex]) < 0) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        double temp = elements[i];
        elements[i] = elements[minIndex];
        elements[minIndex] = temp;
      }
    }
    return elements;
  } 
}
