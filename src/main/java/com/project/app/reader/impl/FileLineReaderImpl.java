package com.project.app.reader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.project.app.exception.ArrayDataException;
import com.project.app.reader.LineReader;

public class FileLineReaderImpl implements LineReader {
  private final Path filePath;

  public FileLineReaderImpl(String path) {
    filePath = Paths.get(path);
  }

  @Override
  public List<String> readLines() throws ArrayDataException {
    try {
      return Files.readAllLines(filePath);
    } catch (IOException e) {
      throw new ArrayDataException("Failed to read file: " + filePath, e);
    }
  }
}
