package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName(
            "when the list is empty"
    )
    @Test
    public void testOddNumbersExterminatorEmptyList() {

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        //When
        List<Integer> actual = oddNumbersExterminator.exterminate(Arrays.asList(
                new Integer[] { }
        ));
        boolean result = actual.isEmpty();

        //Then
        Assertions.assertTrue(result);
    }

    @DisplayName(
            "when the list contains even and odd numbers"
    )
    @Test
    public void testOddNumbersExterminatorNormalList() {

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        //When
        List<Integer> actual = oddNumbersExterminator.exterminate(Arrays.asList(
                new Integer[] { 1, 2, 3, 4, 5, 6 }
        ));

        //Then
        List<Integer> expected = Arrays.asList(
                new Integer[] { 2, 4, 6 }
        );
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
