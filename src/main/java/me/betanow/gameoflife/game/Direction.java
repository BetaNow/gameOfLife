package me.betanow.gameoflife.game;

public enum Direction {
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1),
    UP_LEFT(-1, -1),
    UP_RIGHT(-1, 1),
    DOWN_LEFT(1, -1),
    DOWN_RIGHT(1, 1);

    /**
     * The change in the x-coordinate when moving in this direction.
     */
    private final int dx;

    /**
     * The change in the y-coordinate when moving in this direction.
     */
    private final int dy;

    /**
     * Constructs a new Direction with the given change in x and y coordinates.
     *
     * @param dx - The change in the x-coordinate.
     * @param dy - The change in the y-coordinate.
     */
    Direction (int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Get the number of neighbors of a cell with the given states.
     *
     * @param board  - The board to get the neighbors from.
     * @param cell   - The cell to get the neighbors of.
     * @param states - The states to count as neighbors.
     * @return The number of neighbors of the cell with the given states.
     */
    public static int getNeighbors (Board board, Cell cell, State... states) {
        Direction[] directions = Direction.values();
        int neighbors = 0;

        for (Direction direction : directions) {
            int x = cell.getX() + direction.dx;
            int y = cell.getY() + direction.dy;

            if (board.isInBoard(x, y)) {
                Cell neighbor = board.getCell(x, y);

                for (State state : states) {
                    if (neighbor.getState() == state) {
                        neighbors++;
                        break;
                    }
                }
            }
        }

        return neighbors;
    }
}
