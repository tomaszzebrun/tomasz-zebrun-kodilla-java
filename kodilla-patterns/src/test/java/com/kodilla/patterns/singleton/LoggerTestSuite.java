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
        //Then
        assertEquals("zapisz wczesniej do logow", result);
    }
}
