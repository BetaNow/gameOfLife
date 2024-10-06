package me.betanow.gameoflife.game;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    @Test
    void testToString () {
        assertEquals("A", State.ALIVE.toString());
        assertEquals("D", State.DEAD.toString());
        assertEquals("I", State.INFECTED.toString());
    }

    @Test
    void testToColor () {
        // case ALIVE -> age <= 1 ? Color.rgb(255, 173, 212, 1) : Color.rgb(235, 47, 152, 1);
        // case DEAD -> Color.rgb(255, 255, 255, 0);
        // case INFECTED -> Color.rgb(47, 110, 235, (age / 3.0));

        assertEquals(Color.rgb(255, 173, 212, 1), State.ALIVE.toColor(1));
        assertEquals(Color.rgb(235, 47, 152, 1), State.ALIVE.toColor(2));
        assertEquals(Color.rgb(255, 255, 255, 0), State.DEAD.toColor(0));
        assertEquals(Color.rgb(47, 110, 235, (1 / 3.0)), State.INFECTED.toColor(1));
        assertEquals(Color.rgb(47, 110, 235, (2 / 3.0)), State.INFECTED.toColor(2));
        assertEquals(Color.rgb(47, 110, 235, (3 / 3.0)), State.INFECTED.toColor(3));
    }
}