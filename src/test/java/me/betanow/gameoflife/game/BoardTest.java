package me.betanow.gameoflife.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testClear () {
        Board board = new Board(10, 10);
        board.randomize();
        board.clear();
        for (int k = 0; k < board.getBoard().length; k++) {
            for (int l = 0; l < board.getBoard()[0].length; l++) {
                assertEquals(State.DEAD, board.getCell(k, l).getState());
            }
        }

    }

    @Test
    void testRandomize () {
        Board board = new Board(10, 10);
        board.randomize();
        boolean hasAlive = false;
        int i = 0, j = 0;
        while (!hasAlive && i < 10 && j < 10) {
            if (board.getCell(i, j).getState() == State.ALIVE) {
                hasAlive = true;
            }
            if (i == 9) {
                i = 0;
                j++;
            } else {
                i++;
            }
        }
        assertTrue(hasAlive);
    }

    @Test
    void testIncrementAge () {
        Board board = new Board(10, 10);
        board.clear();
        Board.incrementAge(board.getBoard());
        for (int k = 0; k < board.getBoard().length; k++) {
            for (int l = 0; l < board.getBoard()[0].length; l++) {
                assertEquals(1, board.getCell(k, l).getAge());
            }
        }
    }

    @Test
    void testIsInBoard () {
        Board board = new Board(10, 10);
        assertTrue(board.isInBoard(0, 0));
        assertTrue(board.isInBoard(9, 9));
        assertFalse(board.isInBoard(-1, 0));
        assertFalse(board.isInBoard(0, -1));
        assertFalse(board.isInBoard(10, 0));
        assertFalse(board.isInBoard(0, 10));
    }

    @Test
    void testGetCell () {
        Board board = new Board(10, 10);
        board.clear();
        Cell cell = board.getCell(0, 0);
        assertEquals(0, cell.getX());
        assertEquals(0, cell.getY());
        assertEquals(State.DEAD, cell.getState());
        assertEquals(0, cell.getAge());
    }
}