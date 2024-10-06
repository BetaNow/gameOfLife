package me.betanow.gameoflife.game;

/**
 * The board of the game of life
 */
public class Board {
    /**
     * The board of cells
     */
    private final Cell[][] board;

    /**
     * Create a new board
     *
     * @param width - the width of the board
     * @param height - the height of the board
     */
    public Board (int width, int height) {
        this.board = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                board[x][y] = new Cell(x, y);
            }
        }
    }

    /**
     * Clear the board
     */
    public void clear () {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                cell.setState(State.DEAD);
            }
        }
    }

    /**
     * Randomize the board
     */
    public void randomize () {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                cell.randomize();
            }
        }
    }

    /**
     * Increment the age of the board
     */
    public void increment () {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                cell.incrementAge();
            }
        }
    }

    /**
     * Get the board
     *
     * @return the board
     */
    public Cell[][] getBoard () {
        return board;
    }

    /**
     * Get the cell at the given coordinates
     *
     * @param x - the x coordinate
     * @param y - the y coordinate
     * @return the cell at the given coordinates
     */
    public Cell getCell(int x, int y) {
        return board[x][y];
    }
}
