package com.project.app.service;

import com.project.app.entity.DoubleArrayWrapper;
import com.project.app.exception.ArrayValidationException;

import java.util.Optional;

public interface ArrayCalculationService {
    Optional<Double> findMin(DoubleArrayWrapper array) throws ArrayValidationException;
    Optional<Double> findMax(DoubleArrayWrapper array) throws ArrayValidationException;
    Optional<Double> calculateSum(DoubleArrayWrapper array) throws ArrayValidationException;
    Optional<Double> calculateAverage(DoubleArrayWrapper array) throws ArrayValidationException;
}