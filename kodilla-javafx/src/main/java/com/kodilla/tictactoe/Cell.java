package com.kodilla.tictactoe;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.io.Serializable;

public class Cell implements Serializable {

    Seed content; // content of this cell (Seed.EMPTY, Seed.CROSS, or Seed.NOUGHT)
    int row;
    int col; // row and column of this cell

    /** Constructor to initialize this cell with the specified row and col */
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        clear(); // clear content
    }

    /** Clear this cell's content to EMPTY */
    public void clear() {
        content = Seed.EMPTY;
    }

    // Paint itself on the graphics canvas, given the Graphics context
    public void paint(Pane pane) {
        // Draw the Seed if it is not empty
        int x1 = col * TicTacToe.CELL_SIZE + TicTacToe.CELL_PADDING;
        int y1 = row * TicTacToe.CELL_SIZE + TicTacToe.CELL_PADDING;
        int x2 = (col + 1) * TicTacToe.CELL_SIZE - TicTacToe.CELL_PADDING;
        int y2 = (row + 1) * TicTacToe.CELL_SIZE - TicTacToe.CELL_PADDING;
        if (content == Seed.CROSS) {
            // Cross
            Line line1 = new Line(x1, y1, x2, y2);
            Line line2 = new Line(x2, y1, x1, y2);
            line1.setStroke(TicTacToe.COLOR_CROSS);
            line1.setStrokeWidth(TicTacToe.SYMBOL_STROKE_WIDTH);
            line2.setStroke(TicTacToe.COLOR_CROSS);
            line2.setStrokeWidth(TicTacToe.SYMBOL_STROKE_WIDTH);
            pane.getChildren().addAll(line1, line2);
        } else if (content == Seed.NOUGHT) {
            // Nought
            Circle circle = new Circle((x1+x2)/2, (y1+y2)/2, TicTacToe.SYMBOL_SIZE/2);
            circle.setFill(null);
            circle.setStrokeWidth(TicTacToe.SYMBOL_STROKE_WIDTH);
            circle.setStroke(TicTacToe.COLOR_NOUGHT);
            pane.getChildren().add(circle);
        }
    }
}
