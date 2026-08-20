package com.project.app.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.app.entity.AbstractArrayWrapper;
import com.project.app.repository.ArrayRepository;
import com.project.app.repository.specification.ArraySpecification;

public class DoubleArrayRepositoryImpl implements ArrayRepository {
  private static DoubleArrayRepositoryImpl instance;
  private List<AbstractArrayWrapper> doubleArr;

  private DoubleArrayRepositoryImpl() {
    this.doubleArr = new ArrayList<>();
  }

  public static DoubleArrayRepositoryImpl getInstance(){
    if (instance == null) {
      instance = new DoubleArrayRepositoryImpl();
    }
    return instance;
  }

  @Override
  public boolean save(AbstractArrayWrapper arr) {
    doubleArr.add(arr);
    return true;
  }

  @Override
  public boolean remove(int id) {
    return doubleArr.remove(id) != null;
  }

  public void clear() {
    this.doubleArr.clear();
  }

  @Override
  public List<AbstractArrayWrapper> query(ArraySpecification specification) {
    List<AbstractArrayWrapper> result = new ArrayList<>();
    for (AbstractArrayWrapper arr: doubleArr) {
      if (specification.specify(arr)) {
        result.add(arr);
      }
    }
    return result;
  } 
}
