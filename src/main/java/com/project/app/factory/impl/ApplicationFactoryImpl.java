package com.project.app.factory.impl;

import com.project.app.Application;
import com.project.app.factory.ApplicationFactory;
import com.project.app.factory.ArrayFactory;
import com.project.app.parser.ArrayParser;
import com.project.app.parser.impl.ArrayLineParserImpl;
import com.project.app.reader.LineReader;
import com.project.app.reader.impl.FileLineReaderImpl;
import com.project.app.service.ArrayCalculationService;
import com.project.app.service.ArraySortService;
import com.project.app.service.impl.ArrayCalculationServiceImpl;
import com.project.app.service.impl.ArraySortServiceImpl;
import com.project.app.validation.ArrayValidator;
import com.project.app.validation.impl.ArrayLineValidatorImpl;

public class ApplicationFactoryImpl implements ApplicationFactory {

  @Override
  public Application assemble() {
    LineReader fileReader = new FileLineReaderImpl("tasks.txt");
    ArrayFactory arrFactory = new DoubleArrayFactoryImpl();
    ArrayValidator validator = new ArrayLineValidatorImpl();
    ArrayParser parser = new ArrayLineParserImpl();
    ArrayCalculationService calcService = new ArrayCalculationServiceImpl();
    ArraySortService sortService = new ArraySortServiceImpl();

    return new Application(fileReader, arrFactory, validator, parser, calcService, sortService);
  }
  
}
