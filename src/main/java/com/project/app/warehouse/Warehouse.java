package com.project.app.warehouse;

import java.util.HashMap;
import java.util.Map;

import com.project.app.entity.ArrayParameters;

public class Warehouse {
  private static Warehouse instance;
  private final Map<Integer, ArrayParameters> map;

  private Warehouse() {
    this.map = new HashMap<>();
  }

  public static Warehouse getInstance() {
    if (instance == null) {
      instance = new Warehouse();
    }
    return instance;
  }

  public boolean put (int id, ArrayParameters params) {
    map.put(id, params);
    return true;
  }

  public ArrayParameters get(int id) {
    return map.get(id);
  }

  public boolean remove(int id) {
    return map.remove(id) != null;
  }

  public void clear() {
    this.map.clear();
  }
}
