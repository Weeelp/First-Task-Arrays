package com.project.app.service;

import java.util.List;

import com.project.app.entity.AbstractArrayWrapper;

public interface ArrayService {
  List<AbstractArrayWrapper> findArrayWithSumGreaterThan(double targetSum);
  public List<AbstractArrayWrapper> getAllSortedBySize();
  public List<AbstractArrayWrapper> getAllSortedById();
  public List<AbstractArrayWrapper> getAllSortedByFirstElement();
  public List<AbstractArrayWrapper> getAll();
  public boolean add(AbstractArrayWrapper arr);
  public boolean delete(int id);
  
}
