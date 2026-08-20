package com.project.app.service;

import com.project.app.entity.DoubleArrayWrapper;
import com.project.app.exception.ArrayValidationException;

import java.util.OptionalDouble;

public interface ArrayCalculationService {
    OptionalDouble findMin(DoubleArrayWrapper array) throws ArrayValidationException;
    OptionalDouble findMax(DoubleArrayWrapper array) throws ArrayValidationException;
    OptionalDouble calculateSum(DoubleArrayWrapper array) throws ArrayValidationException;
    OptionalDouble calculateAverage(DoubleArrayWrapper array) throws ArrayValidationException;
}