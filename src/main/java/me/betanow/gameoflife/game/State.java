package me.betanow.gameoflife.game;

import javafx.scene.paint.Color;

/**
 * The state of a cell
 */
public enum State {
    ALIVE,
    DEAD,
    INFECTED;

    /**
     * Get the string representation of the state
     *
     * @return the string representation of the state
     */
    @Override
    public String toString () {
        return switch (this) {
            case ALIVE -> "A";
            case DEAD -> "D";
            case INFECTED -> "I";
        };
    }

    /**
     * Get the color of the state
     *
     * @param age - the age of the cell
     * @return the color of the state
     */
    public Color toColor (int age) {
        return switch (this) {
            case ALIVE -> age == 0 ? Color.rgb(255, 173, 212, 1) : Color.rgb(235, 47, 152, 1);
            case DEAD -> Color.rgb(255, 255, 255, 0);
            case INFECTED -> Color.rgb(47, 110, 235, (age / 3.0));
        };
    }
}
