package com.project.app.reader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.project.app.exception.ArrayDataException;
import com.project.app.reader.LineReader;

public class FileLineReaderImpl implements LineReader {
  private final String filePath;

  public FileLineReaderImpl(String path) {
    filePath = path;
  }

  @Override
  public List<String> readLines() throws ArrayDataException {
    try {
      Path path = Paths.get(filePath);
      return Files.readAllLines(path);
    } catch (IOException |InvalidPathException e) {
      throw new ArrayDataException("Failed to read file: " + filePath, e);
    }
  }
}
