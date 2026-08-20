package com.project.app.repository;

import java.util.List;

import com.project.app.entity.AbstractArrayWrapper;
import com.project.app.repository.specification.ArraySpecification;

public interface ArrayRepository {
  boolean save(AbstractArrayWrapper arr);
  boolean remove(int id);
  List<AbstractArrayWrapper> query(ArraySpecification specification);
}
