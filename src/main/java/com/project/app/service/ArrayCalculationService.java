package com.project.app.service;

import com.project.app.entity.DoubleArrayWrapper;
import java.util.Optional;

public interface ArrayCalculationService {
    Optional<Double> findMin(DoubleArrayWrapper array);
    Optional<Double> findMax(DoubleArrayWrapper array);
    Optional<Double> calculateSum(DoubleArrayWrapper array);
    Optional<Double> calculateAverage(DoubleArrayWrapper array);
}