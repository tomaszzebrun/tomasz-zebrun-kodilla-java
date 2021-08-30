package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskListDaoTestSuite {

    private static final String TASK_LIST_NAME = "TaskListName";
    private static final String TASK_LIST_DESCRIPTION = "Test: TaskList Name";

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(TASK_LIST_NAME,
                TASK_LIST_DESCRIPTION);
        taskListDao.save(taskList);
        String taskListName = taskList.getListName();

        //When
        List<TaskList> readTaskList = taskListDao.findByListName(taskListName);

        //Then
        assertEquals(1, readTaskList.size());

        //CleanUp
        int id = readTaskList.get(0).getId();
        taskListDao.deleteById(id);
    }

}
