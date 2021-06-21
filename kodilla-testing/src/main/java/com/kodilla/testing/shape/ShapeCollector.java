package com.kodilla.testing.shape;

import com.kodilla.testing.forum.ForumPost;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> figures = new ArrayList<>();

    public void addFigure(Shape shape) {
        figures.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return figures.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n >= 0 && n < figures.size()) {
            return figures.get(n);
        }
        return null;
    }

    public String showFigures() {
        if (figures.size()>0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < figures.size() - 1; i++) {
                stringBuilder.append(figures.get(i).getShapeName() + ", ");
            }
            stringBuilder.append(figures.get(figures.size() - 1).getShapeName());
            return stringBuilder.toString();
        };
        return null;
    }

    public List<Shape> getFigures() {
        return figures;
    }
}
