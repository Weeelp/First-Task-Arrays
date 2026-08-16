package com.project.app.entity;

import org.junit.jupiter.api.Test;

import com.project.app.exception.ArrayValidationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoubleArrayWrapperTest {

    private static final double[] FIRST_DATA = new double[]{1.0, 2.0, 3.0};
    private static final double[] SECOND_DATA = new double[]{1.0, 2.0, 3.0};
    private static final double[] DIFFERENT_DATA = new double[]{1.0, 2.0, 4.0};

    @Test
    void shouldBeEqualWhenDataAndIdAreSame() throws Exception {
        // given
        DoubleArrayWrapper first = new DoubleArrayWrapper(1, FIRST_DATA);
        DoubleArrayWrapper second = new DoubleArrayWrapper(1, SECOND_DATA);

        // when
        boolean actual = first.equals(second);

        // then
        assertTrue(actual);
    }

    @Test
    void shouldReturnCorrectSize() throws ArrayValidationException {
        // given
        DoubleArrayWrapper array = new DoubleArrayWrapper(1, FIRST_DATA);

        // when
        int actual = array.size();

        // then
        assertEquals(3, actual);
    }

    @Test
    void shouldHaveSameHashCodeWhenEqual() throws Exception {
        // given
        DoubleArrayWrapper first = new DoubleArrayWrapper(1, FIRST_DATA);
        DoubleArrayWrapper second = new DoubleArrayWrapper(1, SECOND_DATA);

        // when
        int firstHash = first.hashCode();
        int secondHash = second.hashCode();

        // then
        assertEquals(firstHash, secondHash);
    }

    @Test
    void shouldNotBeEqualWhenDataDiffers() throws Exception {
        // given
        DoubleArrayWrapper first = new DoubleArrayWrapper(1, FIRST_DATA);
        DoubleArrayWrapper second = new DoubleArrayWrapper(1, DIFFERENT_DATA);

        // when
        boolean actual = first.equals(second);

        // then
        assertEquals(false, actual);
    }
}