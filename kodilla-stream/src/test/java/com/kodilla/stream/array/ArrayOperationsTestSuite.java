package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] testArray = {1, 2, 3, 4, 5, 6};

        //When
        double result = ArrayOperations.getAverage(testArray);

        //Then
        assertEquals(3.5, result);
    }
}
