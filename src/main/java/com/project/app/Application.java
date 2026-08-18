package com.project.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.project.app.entity.DoubleArrayWrapper;
import com.project.app.exception.*;
import com.project.app.factory.ApplicationFactory;
import com.project.app.factory.ArrayFactory;
import com.project.app.factory.impl.ApplicationFactoryImpl;
import com.project.app.parser.ArrayParser;
import com.project.app.reader.LineReader;
import com.project.app.service.ArrayCalculationService;
import com.project.app.service.ArraySortService;
import com.project.app.validation.ArrayValidator;

import java.util.List;
import java.util.Optional;

public class Application {
  private static final Logger logger = LogManager.getLogger();

  private final ArrayFactory arrFactory;
  private final ArrayValidator validator;
  private final ArrayParser parser;
  private final LineReader reader;
  private final ArrayCalculationService calcService;
  private final ArraySortService sortService;

  public Application(
          LineReader readerValue,
          ArrayFactory arrFactory,
          ArrayValidator validator,
          ArrayParser parser,
          ArrayCalculationService calcService, 
          ArraySortService sortService) {
    this.reader = readerValue;
    this.arrFactory = arrFactory;
    this.validator = validator;
    this.parser = parser;
    this.calcService = calcService;
    this.sortService = sortService;
  }

  public void run() {
    try {
      List<String> lines = reader.readLines();
      for (String line : lines) {
        List<String> errors = validator.validate(line);
        if (!errors.isEmpty()){
          logger.warn("Invalid line: {}", line);
          continue;
        }

        double[] elementsArray = parser.parse(line);

        if(elementsArray == null || elementsArray.length == 0){
          continue;
        }
        
        DoubleArrayWrapper arr = arrFactory.create(elementsArray);
        logger.info("Created array: {}", arr);
        
        Optional<Double> min = calcService.findMin(arr);
        Optional<Double> max = calcService.findMax(arr);
        Optional<Double> sum = calcService.calculateSum(arr);

        double[] mergeSortArr = sortService.sortMerge(arr);
        double[] selectionSortArr = sortService.sortSelection(arr);

        logger.info("Min: {}, Max: {}, Sum: {}", 
                min.orElse(0.0), max.orElse(0.0), sum.orElse(0.0));
        logger.info("Merge sort: {}", mergeSortArr);
        logger.info("Selection sort: {}", selectionSortArr);

      }

      logger.info("File read successfully");
    } catch (ArrayDataException | ArrayValidationException e) {
        logger.error("Failed to read data", e);
    }
  }

  public static void main(String[] args) {
    ApplicationFactory assembler = new ApplicationFactoryImpl();
    Application app = assembler.assemble("tasks.txt");
    app.run();
  }
}