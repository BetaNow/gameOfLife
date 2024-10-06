package me.betanow.gameoflife.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DirectionTest {

    @Test
    void testGetNeighbors () {
        Board board = new Board(3, 3);
        board.clear(); // Set all cells to dead

        // Test with no neighbors and with one neighbor
        board.getCell(1, 1).setState(State.ALIVE);
        assertEquals(0, Direction.getNeighbors(board, board.getCell(1, 1), State.ALIVE));
        assertEquals(1, Direction.getNeighbors(board, board.getCell(0, 0), State.ALIVE));

        // Test with many states searched for
        board.getCell(0, 1).setState(State.INFECTED);
        assertEquals(1, Direction.getNeighbors(board, board.getCell(0, 0), State.DEAD));
        assertEquals(2, Direction.getNeighbors(board, board.getCell(0, 0), State.ALIVE, State.INFECTED));

        // Test with all neighbors
        board.clear();
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                if (i != 1 || j != 1) {
                    board.getCell(i, j).setState(State.ALIVE);
                }
            }
        }
        assertEquals(8, Direction.getNeighbors(board, board.getCell(1, 1), State.ALIVE));

        // Test with an infected cell
        board.getCell(0, 0).setState(State.INFECTED);
        assertEquals(1, Direction.getNeighbors(board, board.getCell(1, 1), State.INFECTED));
        assertEquals(7, Direction.getNeighbors(board, board.getCell(1, 1), State.ALIVE));
        assertEquals(0, Direction.getNeighbors(board, board.getCell(1, 1), State.DEAD));

        // Test with no neighbors
        board.clear();
        assertEquals(0, Direction.getNeighbors(board, board.getCell(1, 1), State.ALIVE));
    }
}