package com.project.app.service.impl;

import com.project.app.entity.DoubleArrayWrapper;
import com.project.app.exception.ArrayValidationException;
import com.project.app.service.ArrayCalculationService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayCalculationServiceImplTest {

    // given — константы с тестовыми данными (через new, не через фабрику!)
    private static final double[] TEST_DATA = new double[]{3.0, 1.0, 4.0, 1.0, 5.0};
    private static final double EXPECTED_MIN = 1.0;
    private static final double EXPECTED_MAX = 5.0;
    private static final double EXPECTED_SUM = 14.0;

    @Test
    void shouldFindMinValue() throws ArrayValidationException {
        // given
        DoubleArrayWrapper array = new DoubleArrayWrapper(1, TEST_DATA);
        ArrayCalculationService service = new ArrayCalculationServiceImpl();

        // when
        Optional<Double> actual = service.findMin(array);

        // then
        assertEquals(EXPECTED_MIN, actual.orElse(0.0));
    }

    @Test
    void shouldFindMaxValue() throws ArrayValidationException {
        // given
        DoubleArrayWrapper array = new DoubleArrayWrapper(1, TEST_DATA);
        ArrayCalculationService service = new ArrayCalculationServiceImpl();

        // when
        Optional<Double> actual = service.findMax(array);

        // then
        assertEquals(EXPECTED_MAX, actual.orElse(0.0));
    }

    @Test
    void shouldCalculateSum() throws ArrayValidationException {
        // given
        DoubleArrayWrapper array = new DoubleArrayWrapper(1, TEST_DATA);
        ArrayCalculationService service = new ArrayCalculationServiceImpl();

        // when
        Optional<Double> actual = service.calculateSum(array);

        // then
        assertEquals(EXPECTED_SUM, actual.orElse(0.0));
    }
}