package me.betanow.gameoflife.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CellTest {

    @Test
    void testRandomize () {
        for (int i = 0; i < 50; i++) {
            Cell cell = new Cell(0, 0);
            cell.randomize();
            assertNotNull(cell.getState());
            assertTrue(cell.getAge() >= 1 && cell.getAge() <= 3);
        }
    }

    @Test
    void testGetX () {
        Cell cell = new Cell(5, 10);
        assertEquals(5, cell.getX());

        cell = new Cell(10, 5);
        assertEquals(10, cell.getX());

        cell = new Cell(0, 0);
        assertEquals(0, cell.getX());

        cell = new Cell(-5, -10);
        assertEquals(-5, cell.getX());
    }

    @Test
    void testGetY () {
        Cell cell = new Cell(5, 10);
        assertEquals(10, cell.getY());

        cell = new Cell(10, 5);
        assertEquals(5, cell.getY());

        cell = new Cell(0, 0);
        assertEquals(0, cell.getY());

        cell = new Cell(-5, -10);
        assertEquals(-10, cell.getY());
    }

    @Test
    void testGetState () {
        Cell cell = new Cell(0, 0);

        cell.setState(State.ALIVE);
        assertEquals(State.ALIVE, cell.getState());

        cell.setState(State.DEAD);
        assertEquals(State.DEAD, cell.getState());

        cell.setState(State.INFECTED);
        assertEquals(State.INFECTED, cell.getState());
    }

    @Test
    void testGetAge () {
        Cell cell = new Cell(0, 0);

        cell.setAge(0);
        assertEquals(0, cell.getAge());

        cell.setAge(1);
        assertEquals(1, cell.getAge());

        cell.setAge(10);
        assertEquals(10, cell.getAge());

        cell.setAge(-1);
        assertEquals(-1, cell.getAge());
    }

    @Test
    void testSetState () {
        Cell cell = new Cell(0, 0);

        cell.setState(State.ALIVE);
        assertEquals(State.ALIVE, cell.getState());

        cell.setState(State.DEAD);
        assertEquals(State.DEAD, cell.getState());

        cell.setState(State.INFECTED);
        assertEquals(State.INFECTED, cell.getState());
    }

    @Test
    void testSetAge () {
        Cell cell = new Cell(0, 0);

        cell.setAge(0);
        assertEquals(0, cell.getAge());

        cell.setAge(1);
        assertEquals(1, cell.getAge());

        cell.setAge(10);
        assertEquals(10, cell.getAge());

        cell.setAge(-1);
        assertEquals(-1, cell.getAge());
    }

    @Test
    void testIncrementAge () {
        Cell cell = new Cell(0, 0);

        cell.incrementAge();
        assertEquals(1, cell.getAge());

        cell.incrementAge();
        assertEquals(2, cell.getAge());

        cell.incrementAge();
        assertEquals(3, cell.getAge());

        cell.incrementAge();
        assertEquals(4, cell.getAge());
    }

    @Test
    void testToString () {
        Cell cell = new Cell(0, 0);

        cell.setState(State.ALIVE);
        assertEquals("A", cell.toString());

        cell.setState(State.INFECTED);
        assertEquals("I", cell.toString());

        cell.setState(State.DEAD);
        assertEquals("D", cell.toString());
    }
}