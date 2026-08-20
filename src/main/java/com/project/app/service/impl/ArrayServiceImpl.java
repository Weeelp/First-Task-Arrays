package com.project.app.service.impl;

import java.util.List;

import com.project.app.entity.AbstractArrayWrapper;
import com.project.app.repository.ArrayRepository;
import com.project.app.repository.comparator.*;
import com.project.app.repository.specification.impl.SumGreaterThanSpecification;
import com.project.app.service.ArrayService;

public class ArrayServiceImpl implements ArrayService {
  private final ArrayRepository repository;

  public ArrayServiceImpl (ArrayRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<AbstractArrayWrapper> findArrayWithSumGreaterThan(double targetSum) {
    return repository.query(new SumGreaterThanSpecification(targetSum));
  }

  @Override
  public List<AbstractArrayWrapper> getAllSortedBySize() {
    List<AbstractArrayWrapper> all = repository.findAll();
    all.sort(new ArraySizeComparator());
    return all;
  }

  @Override
  public List<AbstractArrayWrapper> getAllSortedById() {
    List<AbstractArrayWrapper> all = repository.findAll();
    all.sort(new IdComparator());
    return all;
  }

  @Override
  public List<AbstractArrayWrapper> getAllSortedByFirstElement() {
    List<AbstractArrayWrapper> all = repository.findAll();
    all.sort(new FirstElementComparator());
    return all;
  } 

  @Override
  public List<AbstractArrayWrapper> getAll() {
    return repository.findAll();
  }
  
  @Override
  public boolean add(AbstractArrayWrapper arr) {
    return repository.save(arr);
  }
  
  @Override
  public boolean delete(int id) {
    return repository.deleteById(id);
  }

}
