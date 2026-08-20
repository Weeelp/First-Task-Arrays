package com.project.app.repository.comparator;

import java.util.Comparator;

import com.project.app.entity.AbstractArrayWrapper;

public class FirstElementComparator implements Comparator<AbstractArrayWrapper> {

  @Override
  public int compare(AbstractArrayWrapper arg0, AbstractArrayWrapper arg1) {
    double[] arr1 = arg0.getAll();
    double[] arr2 = arg1.getAll();
    
    if (arr1.length == 0 && arr2.length == 0) return 0;
    if (arr1.length == 0) return -1;
    if (arr2.length == 0) return 1;
    
    return Double.compare(arr1[0], arr2[0]);
  }
}