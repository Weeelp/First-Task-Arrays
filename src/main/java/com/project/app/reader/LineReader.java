package com.project.app.reader;

import java.util.List;

import com.project.app.exception.ArrayDataException;

public interface LineReader {  
  public List<String> readLines() throws ArrayDataException;
}
