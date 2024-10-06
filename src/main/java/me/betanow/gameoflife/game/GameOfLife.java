package me.betanow.gameoflife.game;

import javafx.scene.layout.GridPane;

/**
 * The game of life
 */
public class GameOfLife {
    /**
     * The grid pane
     */
    private final GridPane GRID_PANE;

    /**
     * The size of the cells
     */
    private static final int CELL_SIZE = 20;

    /**
     * The board
     */
    private final Board board;

    /**
     * Create a new game of life
     *
     * @param gridPane - the grid pane
     */
    public GameOfLife (GridPane gridPane) {
        this.GRID_PANE = gridPane;

        int width = (int) gridPane.getWidth() / CELL_SIZE;
        int height = (int) gridPane.getHeight() / CELL_SIZE;

        board = new Board(width, height);
        randomize();
    }

    /**
     * Get the cell size
     *
     * @return the cell size
     */
    public static int getCellSize () {
        return CELL_SIZE;
    }

    /**
     * Play the game
     */
    public void randomize () {
        board.randomize();
        draw();
    }

    /**
     * Clear the board
     */
    public void clear () {
        board.clear();
        draw();
    }

    /**
     * Do the next generation
     */
    public void nextGeneration () {
        board.nextGeneration();
        draw();
    }

    /**
     * Increment the board
     */
    public void draw () {
        GRID_PANE.getChildren().clear();
        for (Cell[] cells : board.getBoard()) {
            for (Cell cell : cells) {
                GRID_PANE.add(cell.getRectangle(), cell.getX(), cell.getY());
            }
        }
    }
}
