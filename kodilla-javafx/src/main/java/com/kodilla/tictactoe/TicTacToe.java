package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    // Named-constants for the game board
    public static final int ROWS = 3;  // ROWS by COLS cells
    public static final int COLS = 3;
    public static final String TITLE = "Kółko i krzyżyk";

    // Name-constants for the various dimensions used for graphics drawing
    public static final int CELL_SIZE = 120; // cell width and height (square)
    public static final int CANVAS_WIDTH = CELL_SIZE * COLS;  // the drawing canvas
    public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
    public static final int GRID_WIDTH = 4;  // Grid-line's width
    public static final int GRID_WIDHT_HALF = GRID_WIDTH / 2; // Grid-line's half-width

    // Symbols (cross/nought) are displayed inside a cell, with padding from border
    public static final int CELL_PADDING = CELL_SIZE / 6;
    public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;
    public static final int SYMBOL_STROKE_WIDTH = 4; // pen's stroke width

    // Colors
    public static final Color COLOR_GRID = Color.BLACK;
    public static final Color COLOR_CROSS = Color.BLUE;
    public static final Color COLOR_NOUGHT = Color.RED;
    public static final Color COLOR_STATE_PLAYNG = Color.BLACK;
    public static final Color COLOR_STATE_STOP = Color.RED;

    public static Stage mainStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getClassLoader().getResource("tictactoe.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("tictactoe.css").toExternalForm());

        mainStage = primaryStage;

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle(TITLE);
        primaryStage.show();
    }


}
