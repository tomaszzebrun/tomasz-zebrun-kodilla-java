package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    Calculator calculator;

    @Test
    void testCalculations() {
        //Given

        //When
        double resultAdd = calculator.add(2,3);
        double resultSub = calculator.sub(2,3);
        double resultMul = calculator.mul(2,3);
        double resultDiv = calculator.div(2,3);

        //Then
        assertEquals(5.0, resultAdd);
        assertEquals(-1.0, resultSub);
        assertEquals(6.0, resultMul);
        assertEquals(0.666666, resultDiv, 0.000001);
    }
}
