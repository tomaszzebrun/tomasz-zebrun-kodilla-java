package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.toDoList.tasks.add("toDo task");
        board.inProgressList.tasks.add("inProgress task");
        board.doneList.tasks.add("done task");
        String toDoTask = board.toDoList.tasks.get(0);
        String inProgressTask = board.inProgressList.tasks.get(0);
        String doneTask = board.doneList.tasks.get(0);

        //Then
        assertEquals("toDo task", toDoTask);
        assertEquals("inProgress task", inProgressTask);
        assertEquals("done task", doneTask);
    }
}
