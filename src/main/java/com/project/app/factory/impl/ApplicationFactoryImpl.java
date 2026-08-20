package com.project.app.factory.impl;

import com.project.app.Application;
import com.project.app.factory.*;
import com.project.app.parser.ArrayParser;
import com.project.app.parser.impl.ArrayLineParserImpl;
import com.project.app.reader.LineReader;
import com.project.app.reader.impl.FileLineReaderImpl;
import com.project.app.repository.ArrayRepository;
import com.project.app.repository.impl.DoubleArrayRepositoryImpl;
import com.project.app.service.*;
import com.project.app.service.impl.*;
import com.project.app.validator.ArrayValidator;
import com.project.app.validator.impl.ArrayLineValidatorImpl;

public class ApplicationFactoryImpl implements ApplicationFactory {

  @Override
  public Application assemble(String filePath) {
    LineReader fileReader = new FileLineReaderImpl(filePath);
    ArrayFactory arrFactory = new DoubleArrayFactoryImpl();
    ArrayValidator validator = new ArrayLineValidatorImpl();
    ArrayParser parser = new ArrayLineParserImpl();
    ArrayCalculationService calcService = new ArrayCalculationServiceImpl();
    ArraySortService sortService = new ArraySortServiceImpl();
    ArrayRepository arrRepository = DoubleArrayRepositoryImpl.getInstance();
    ArrayService arrService = new ArrayServiceImpl(arrRepository);

    return new Application(fileReader, 
      arrFactory, 
      validator, 
      parser, 
      calcService, 
      sortService, 
      arrService);
  }
  
}
