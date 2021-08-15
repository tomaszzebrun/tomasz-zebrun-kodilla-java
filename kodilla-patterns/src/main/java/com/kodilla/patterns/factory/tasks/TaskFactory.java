package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING = "ShoppingTask";
    public static final String PAINTING = "PaintingTask";
    public static final String DRIVING = "DrivingTask";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Shopping task", "Kalosze", 1.0);
            case PAINTING:
                return new PaintingTask("Painting task", "Zielony", "Ściana");
            case DRIVING:
                return new DrivingTask("Driving task", "Ciocia", "Rower");
            default:
                return null;
        }

    }
}
