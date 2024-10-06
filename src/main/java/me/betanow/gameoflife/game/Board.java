package me.betanow.gameoflife.game;

/**
 * The board of the game of life
 */
public class Board {
    /**
     * The board of cells
     */
    private Cell[][] board;

    /**
     * Create a new board
     *
     * @param width  - the width of the board
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
    public void nextGeneration () {
        Cell[][] newBoard = new Cell[board.length][board[0].length];

        // Game of life rules
        // 1. Any live cell with fewer than two live neighbors dies, as if by underpopulation.
        // 2. Any live cell with two or three live neighbors lives on to the next generation.
        // 3. Any live cell with more than three live neighbors dies, as if by overpopulation.
        // 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                Cell cell = board[x][y];
                int neighbors = Direction.getNeighbors(this, cell, State.ALIVE); // TODO: Implement INFECTION

                newBoard[x][y] = new Cell(x, y);
                newBoard[x][y].setState(cell.getState());
                newBoard[x][y].setAge(cell.getAge());

                if (cell.getState() == State.ALIVE) {
                    if (neighbors < 2 || neighbors > 3) {
                        newBoard[x][y].setState(State.DEAD);
                    }
                } else {
                    if (neighbors == 3) {
                        newBoard[x][y].setState(State.ALIVE);
                    }
                }
            }
        }

        incrementAge(newBoard);
        board = newBoard;
    }

    /**
     * Increment the age of the board
     *
     * @param board - the board to increment the age of
     */
    public static void incrementAge (Cell[][] board) {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                cell.incrementAge();
            }
        }
    }

    /**
     * Return if the given coordinates are in the board
     *
     * @param x - The x coordinate
     * @param y - The y coordinate
     * @return True if the coordinates are in the board, false otherwise
     */
    public boolean isInBoard (int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    // Getters

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
    public Cell getCell (int x, int y) {
        return board[x][y];
    }
}
