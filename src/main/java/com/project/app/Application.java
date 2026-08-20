package com.project.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.project.app.entity.DoubleArrayWrapper;
import com.project.app.exception.*;
import com.project.app.factory.*;
import com.project.app.factory.impl.ApplicationFactoryImpl;
import com.project.app.observer.ArrayObserver;
import com.project.app.observer.impl.ArrayObserverImpl;
import com.project.app.parser.ArrayParser;
import com.project.app.reader.LineReader;
import com.project.app.service.*;
import com.project.app.validator.ArrayValidator;

import java.util.List;

public class Application {
  private static final Logger log = LogManager.getLogger();

  private final LineReader reader;
  private final ArrayValidator validator;
  private final ArrayParser parser;
  private final ArrayFactory arrFactory;
  @SuppressWarnings("unused")
  private final ArrayCalculationService calcService;
  @SuppressWarnings("unused")
  private final ArraySortService sortService;
  private final ArrayService arrService;

  public Application(
          LineReader readerValue,
          ArrayFactory arrFactory,
          ArrayValidator validator,
          ArrayParser parser,
          ArrayCalculationService calcService, 
          ArraySortService sortService,
          ArrayService arrService) {
    this.reader = readerValue;
    this.arrFactory = arrFactory;
    this.validator = validator;
    this.parser = parser;
    this.calcService = calcService;
    this.sortService = sortService;
    this.arrService = arrService;
  }

  public void run() {
    try {
      List<String> lines = reader.readLines();
      ArrayObserver observer = new ArrayObserverImpl();
      for (String line : lines) {
        List<String> errors = validator.validate(line);
        if (!errors.isEmpty()){
          log.warn("Invalid line: {}", line);
          continue;
        }

        double[] elementsArray = parser.parse(line);

        if(elementsArray == null || elementsArray.length == 0){
          continue;
        }
        
        DoubleArrayWrapper arr = arrFactory.create(elementsArray);
        arr.setObserver(observer);
        observer.handleEvent(arr);
        arrService.add(arr);
        log.info("Created array: {}\n", arr);
        log.info(arrService.getAllSortedByFirstElement()+"\n");
        log.info(arrService.findArrayWithSumGreaterThan(1)+"\n");
        log.info(arrService.getAll()+"\n");
        
                
      }

      log.info("File read successfully");
    } catch (ArrayDataException | ArrayValidationException e) {
        log.error("Failed to read data", e);
    }
  }

  public static void main(String[] args) {
    ApplicationFactory assembler = new ApplicationFactoryImpl();
    Application app = assembler.assemble("tasks.txt");
    app.run();
  }
}