package com.project.app.repository.comparator;

import java.util.Comparator;

import com.project.app.entity.AbstractArrayWrapper;

public class IdComparator implements Comparator<AbstractArrayWrapper>{

  @Override
  public int compare(AbstractArrayWrapper arg0, AbstractArrayWrapper arg1) {
    return Integer.compare(arg0.getId(), arg1.getId());
  }
  
}
