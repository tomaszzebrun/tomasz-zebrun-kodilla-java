package com.kodilla.patterns2.observer.homework;

public class CourseMentor implements Observer{

    private final String username;
    private int updateCount;

    public CourseMentor(String username) {
        this.username = username;
    }

    @Override
    public void update(TasksQueue tasksQueue) {
        System.out.println("Mentor: " + username + ": new task in queue: " + tasksQueue.getName());
        updateCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
