package com.kodilla.tictactoe;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.util.*;

public class TicTacToeController implements Initializable {

    private Board board;            // the game board
    private State currentState;     // the current state of the game
    private Seed currentPlayer;     // the current player

    @FXML
    private Pane gamePane;
    @FXML
    private Label gameStatusLabel;
    @FXML
    private CheckMenuItem menuVsKomputer;

    @FXML
    private void vsKomputerAction(ActionEvent event) {
        //menuVsKomputer.isSelected();

    }

    @FXML
    private void otworzAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Otwórz plik");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Pliki TTT", "*.ttt")
        );
        File file = fileChooser.showOpenDialog(TicTacToe.mainStage);
        if (file != null) {
            try {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    BufferedInputStream bufferedInputStream
                            = new BufferedInputStream(fileInputStream);
                    ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
                    try {
                        board = (Board) objectInputStream.readObject();
                        currentState = (State) objectInputStream.readObject();
                        currentPlayer = (Seed) objectInputStream.readObject();
                        board.repaint(gamePane, true);
                        repaintGameStatus();
                    } catch (EOFException eof) {
                        bufferedInputStream.close();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Nie znaleziono pliku.");
                }
            } catch (IOException e) {
                System.out.println("Bład wejścia wyjścia.");
            }
        }
    }

    @FXML
    private void zapiszAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Zapisz plik");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Pliki TTT", "*.ttt")
        );
        File file = fileChooser.showSaveDialog(TicTacToe.mainStage);
        if (file != null) {
            try {
                if (file.exists()) {
                    file.delete();
                }
                if (file.createNewFile()) {
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                BufferedOutputStream bufferedOutputStream =
                        new BufferedOutputStream(fileOutputStream);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
                objectOutputStream.writeObject(board);
                objectOutputStream.writeObject(currentState);
                objectOutputStream.writeObject(currentPlayer);
                bufferedOutputStream.close();
            } catch (IOException e) {
                System.out.println("Błąd zapisu do pliku");
            }
        }
    }

    @FXML
    private void zamknijAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void nowaGraAction(ActionEvent event) {
        initGame();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Background background = new Background(
                new BackgroundFill(
                        new LinearGradient(0, 0, 0, 1, true,
                                CycleMethod.NO_CYCLE,
                                new Stop(0, Color.web("#FFFFFF")),
                                new Stop(1, Color.web("#DDDDDD"))
                        ), CornerRadii.EMPTY, Insets.EMPTY
                ));
        gamePane.setBackground(background);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                int mouseX = (int) e.getX();
                int mouseY = (int) e.getY();
                // Get the row and column clicked
                int rowSelected = mouseY / TicTacToe.CELL_SIZE;
                int colSelected = mouseX / TicTacToe.CELL_SIZE;

                if (currentState == State.PLAYING) {
                    if (rowSelected >= 0 && rowSelected < TicTacToe.ROWS
                            && colSelected >= 0 && colSelected < TicTacToe.COLS
                            && board.cells[rowSelected][colSelected].content == Seed.EMPTY) {
                        board.cells[rowSelected][colSelected].content = currentPlayer; // move
                        updateGame(currentPlayer, rowSelected, colSelected); // update currentState
                        // Switch player
                        currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;

                    }
                } else {         // game over
                    initGame();  // restart the game
                }
                // Refresh the drawing canvas
                if (currentState == State.PLAYING && menuVsKomputer.isSelected() && currentPlayer == Seed.NOUGHT) {
                    computerMove();
                }
                repaint(gamePane);
            }
        };
        gamePane.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        board = new Board();   // allocate the game-board
        initGame();
    }

    private void computerMove() {
        repaint(gamePane);
        List<Cell> emptyCells = new ArrayList<>();
        for (int row = 0; row < TicTacToe.ROWS; ++row) {
            for (int col = 0; col < TicTacToe.COLS; ++col) {
                if (board.cells[row][col].content == Seed.EMPTY) {
                    emptyCells.add(board.cells[row][col]);
                }
            }
        }
        Random random = new Random();
        int computerCell = random.nextInt(emptyCells.size());
        int rowSelected = emptyCells.get(computerCell).row;
        int colSelected = emptyCells.get(computerCell).col;
        board.cells[rowSelected][colSelected].content = currentPlayer; // move
        updateGame(currentPlayer, rowSelected, colSelected); // update currentState
        // Switch player
        currentPlayer = Seed.CROSS;
    }

    public void initGame() {
        currentState = State.NEW_GAME;  // ready to play
        currentPlayer = Seed.CROSS;     // cross plays first
        board.init();
        repaint(gamePane);
        currentState = State.PLAYING;
    }

    public void updateGame(Seed theSeed, int row, int col) {
        if (board.hasWon(theSeed, row, col)) {  // check for win
            currentState = (theSeed == Seed.CROSS) ? State.CROSS_WON : State.NOUGHT_WON;
        } else if (board.isDraw()) {  // check for draw
            currentState = State.DRAW;
        }
        // Otherwise, no change to current state (PLAYING).
    }

    public void repaint(Pane pane) {
        board.repaint(pane, currentState == State.NEW_GAME);  // ask the game board to paint itself
        repaintGameStatus();
    }

    public void repaintGameStatus() {
        // Print status-bar message
        if (currentState == State.NEW_GAME || currentState == State.PLAYING) {
            gameStatusLabel.setTextFill(TicTacToe.COLOR_STATE_PLAYNG);
            if (currentPlayer == Seed.CROSS) {
                gameStatusLabel.setText("X's Turn");
            } else {
                gameStatusLabel.setText("O's Turn");
            }
        } else if (currentState == State.DRAW) {
            gameStatusLabel.setTextFill(TicTacToe.COLOR_STATE_STOP);
            gameStatusLabel.setText("It's a Draw! Click to play again.");
        } else if (currentState == State.CROSS_WON) {
            gameStatusLabel.setTextFill(TicTacToe.COLOR_STATE_STOP);
            gameStatusLabel.setText("'X' Won! Click to play again.");
        } else if (currentState == State.NOUGHT_WON) {
            gameStatusLabel.setTextFill(TicTacToe.COLOR_STATE_STOP);
            gameStatusLabel.setText("'O' Won! Click to play again.");
        }
    }


}
