package com.project.app.observer;

import com.project.app.entity.AbstractArrayWrapper;

public interface ArrayObserver {
  void handleEvent(AbstractArrayWrapper arr);
}
