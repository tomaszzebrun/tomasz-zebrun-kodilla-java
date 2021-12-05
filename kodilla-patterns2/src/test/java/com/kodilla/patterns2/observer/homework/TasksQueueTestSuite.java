package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TasksQueueTestSuite {

    @Test
    public void testTasksQueueUpdate() {
        //Given
        TasksQueue firstQueue = new StudentQueue("pierwsza kolejka");
        TasksQueue secondQueue = new StudentQueue("druga kolejka");
        CourseMentor firstMentor = new CourseMentor("Jan Kowalski");
        CourseMentor secondMentor = new CourseMentor("Andrzej Nowak");
        firstQueue.registerObserver(firstMentor);
        secondQueue.registerObserver(firstMentor);
        secondQueue.registerObserver(secondMentor);
        //When
        firstQueue.addTask("Zadanie 1");
        firstQueue.addTask("Zadanie 2");
        secondQueue.addTask("Zadanie 3");
        //Then
        assertEquals(3, firstMentor.getUpdateCount());
        assertEquals(1, secondMentor.getUpdateCount());
    }
}
