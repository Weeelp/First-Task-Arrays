package com.project.app.repository;

import java.util.List;
import java.util.Optional;

import com.project.app.entity.AbstractArrayWrapper;
import com.project.app.repository.specification.ArraySpecification;

public interface ArrayRepository {
  boolean save(AbstractArrayWrapper arr);
  Optional<AbstractArrayWrapper> findById(int id);
  List<AbstractArrayWrapper> findAll();
  boolean deleteById(int id);
  List<AbstractArrayWrapper> query(ArraySpecification specification);
}
