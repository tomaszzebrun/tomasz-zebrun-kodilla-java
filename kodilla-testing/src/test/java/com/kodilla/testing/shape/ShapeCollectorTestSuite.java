package com.kodilla.testing.shape;

import com.kodilla.testing.collection.OddNumbersExterminator;
import com.kodilla.testing.forum.ForumPost;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

/*    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }*/

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Begin testing");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("End testing");
    }

    @Nested
    @DisplayName(
            "Tests for figures"
    )
    class TestFigures {

        @DisplayName(
                "when add the figure to collector"
        )
        @Test
        public void testShapeCollectorAddFigure() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle();

            //When
            shapeCollector.addFigure(circle);

            //Then
            assertEquals(1, shapeCollector.getFigures().size());
        }

        @DisplayName(
                "when get the figure from collector"
        )
        @Test
        public void testShapeCollectorGetFigure() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square();
            shapeCollector.addFigure(square);

            //When
            Shape retrievedFigure;
            retrievedFigure = shapeCollector.getFigure(0);

            //Then
            assertEquals(square, retrievedFigure);
        }

        @DisplayName(
                "when remove the figure from collector when the figure not existing "
        )
        @Test
        public void testShapeCollectorRemoveFigureNotExisting() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle();

            //When
            boolean result = shapeCollector.removeFigure(triangle);

            //Then
            assertFalse(result);
        }

        @DisplayName(
                "when remove the figure from collector"
        )
        @Test
        public void testShapeCollectorRemoveFigure() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle();
            shapeCollector.addFigure(circle);

            //When
            boolean result = shapeCollector.removeFigure(circle);

            //Then
            assertTrue(result);
            assertEquals(0, shapeCollector.getFigures().size());
        }
    }

    @Nested
    @DisplayName(
            "Tests for collector"
    )
    class TestCollector {

        @DisplayName(
                " when show figures from collector"
        )
        @Test
        public void testShapeCollectorShowFigures() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle();
            Square square = new Square();
            Triangle triangle = new Triangle();
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);

            //When
            String result = shapeCollector.showFigures();

            //Then
            assertEquals("Circle, Square, Triangle", result);
        }
    }
}
