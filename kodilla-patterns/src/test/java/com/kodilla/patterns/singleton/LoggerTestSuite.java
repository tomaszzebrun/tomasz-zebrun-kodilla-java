package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    @Test
    void testGetLastLog() {
        //Given
        Logger logger = Logger.INSTANCE;
        logger.log("zapisz wczesniej do logow");

        //When
        String result = logger.getLastLog();
        Logger loggerSingletonTest = Logger.INSTANCE;
        String resultSingletonTest = loggerSingletonTest.getLastLog();

        //Then
        assertEquals("zapisz wczesniej do logow", result);
        assertEquals("zapisz wczesniej do logow", resultSingletonTest);
    }
}
