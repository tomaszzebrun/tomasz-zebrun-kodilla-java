package com.kodilla.tictactoe;


import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Board {

    Cell[][] cells; // composes of 2D array of ROWS-by-COLS Cell instances

    /** Constructor to initialize the game board */
    public Board() {
        cells = new Cell[TicTacToe.ROWS][TicTacToe.COLS]; // allocate the array
        for (int row = 0; row < TicTacToe.ROWS; ++row) {
            for (int col = 0; col < TicTacToe.COLS; ++col) {
                cells[row][col] = new Cell(row, col); // allocate element of array
            }
        }
    }

    /** Initialize (or re-initialize) the game board */
    public void init() {
        for (int row = 0; row < TicTacToe.ROWS; ++row) {
            for (int col = 0; col < TicTacToe.COLS; ++col) {
                cells[row][col].clear(); // clear the cell content
            }
        }
    }

    /** Return true if it is a draw (i.e., no more EMPTY cell) */
    public boolean isDraw() {
        for (int row = 0; row < TicTacToe.ROWS; ++row) {
            for (int col = 0; col < TicTacToe.COLS; ++col) {
                if (cells[row][col].content == Seed.EMPTY) {
                    return false; // an empty seed found, not a draw, exit
                }
            }
        }
        return true; // no empty cell, it's a draw
    }

    /** Return true if the player with "seed" has won after placing at
     (seedRow, seedCol) */
    public boolean hasWon(Seed seed, int seedRow, int seedCol) {
        return (cells[seedRow][0].content == seed   // 3-in-the-row
                && cells[seedRow][1].content == seed
                && cells[seedRow][2].content == seed
                || cells[0][seedCol].content == seed // 3-in-the-column
                && cells[1][seedCol].content == seed
                && cells[2][seedCol].content == seed
                || seedRow == seedCol              // 3-in-the-diagonal
                && cells[0][0].content == seed
                && cells[1][1].content == seed
                && cells[2][2].content == seed
                || seedRow + seedCol == 2          // 3-in-the-opposite-diagonal
                && cells[0][2].content == seed
                && cells[1][1].content == seed
                && cells[2][0].content == seed);
    }

    /** Paint itself on the graphics canvas, given the Graphics context */
    public void repaint(Pane pane, boolean clearBoard) {

        if (clearBoard) {
            // Clear
            pane.getChildren().clear();
            // Draw the grid-lines
            for (int row = 1; row < TicTacToe.ROWS; ++row) {
                Rectangle rectangle = new Rectangle(0, TicTacToe.CELL_SIZE * row - TicTacToe.GRID_WIDHT_HALF,
                        TicTacToe.CANVAS_WIDTH - 1, TicTacToe.GRID_WIDTH);
                rectangle.setStroke(TicTacToe.COLOR_GRID);
                rectangle.setStrokeWidth(TicTacToe.GRID_WIDTH);
                pane.getChildren().add(rectangle);
            }
            for (int col = 1; col < TicTacToe.COLS; ++col) {
                Rectangle rectangle = new Rectangle(TicTacToe.CELL_SIZE * col - TicTacToe.GRID_WIDHT_HALF, 0,
                        TicTacToe.GRID_WIDTH, TicTacToe.CANVAS_HEIGHT - 1);
                rectangle.setStroke(TicTacToe.COLOR_GRID);
                rectangle.setStrokeWidth(TicTacToe.GRID_WIDTH);
                pane.getChildren().add(rectangle);
            }
        }

        // Draw all the cells
        for (int row = 0; row < TicTacToe.ROWS; ++row) {
            for (int col = 0; col < TicTacToe.COLS; ++col) {
                cells[row][col].paint(pane);  // ask the cell to paint itself
            }
        }
    }
}
