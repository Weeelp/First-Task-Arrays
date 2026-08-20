package com.project.app.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.project.app.entity.AbstractArrayWrapper;
import com.project.app.repository.ArrayRepository;
import com.project.app.repository.specification.ArraySpecification;

public class DoubleArrayRepositoryImpl implements ArrayRepository {
  private static DoubleArrayRepositoryImpl instance;
  private Map<Integer, AbstractArrayWrapper> doubleArr;

  private DoubleArrayRepositoryImpl() {
    this.doubleArr = new HashMap<>();
  }

  public static DoubleArrayRepositoryImpl getInstance(){
    if (instance == null) {
      instance = new DoubleArrayRepositoryImpl();
    }
    return instance;
  }

  @Override
  public boolean save(AbstractArrayWrapper arr) {
    doubleArr.put(arr.getId(), arr);
    return true;
  }

  @Override
  public Optional<AbstractArrayWrapper> findById(int id) {
    return Optional.ofNullable(doubleArr.get(id));
  }

  @Override
  public List<AbstractArrayWrapper> findAll() {
    return new ArrayList<>(doubleArr.values());
  }

  @Override
  public boolean deleteById(int id) {
    return doubleArr.remove(id) != null;
  }

  public void clear() {
    this.doubleArr.clear();
  }

  @Override
  public List<AbstractArrayWrapper> query(ArraySpecification specification) {
    List<AbstractArrayWrapper> result = new ArrayList<>();
    for (AbstractArrayWrapper arr: doubleArr.values()) {
      if (specification.specify(arr)) {
        result.add(arr);
      }
    }
    return result;
  } 
}
