package me.betanow.gameoflife.game;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

/**
 * A cell in the game of life
 */
public class Cell {
    /**
     * The x coordinate of the cell
     */
    private final int x;

    /**
     * The y coordinate of the cell
     */
    private final int y;

    /**
     * The state of the cell
     */
    private State state;

    /**
     * The age of the cell
     */
    private int age = 0;

    /**
     * Create a new cell
     *
     * @param x - the x coordinate of the cell
     * @param y - the y coordinate of the cell
     */
    public Cell (int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Create a random cell
     */
    public void randomize () {
        State[] states = new State[]{ State.ALIVE, State.DEAD, State.DEAD, State.DEAD };

        // Set the state of the cell and the age of the cell
        this.setState(states[(int) (Math.random() * states.length)]);
        this.setAge(1 + (int) (Math.random() * 2));
    }

    /**
     * Get the rectangle of the cell
     *
     * @return the rectangle of the cell
     */
    public Node getRectangle () {
        // Create a rectangle
        int size = GameOfLife.getCellSize();
        Rectangle rectangle = new Rectangle(size, size);

        // Set the fill of the rectangle
        rectangle.setFill(state.toColor(age));

        // Add click event
        // To show the state of the cell, and the age of the cell
        rectangle.setOnMouseClicked(event->System.out.println("State: " + state + ", Age: " + age));

        return rectangle;
    }

    // Getters

    /**
     * Get the x coordinate of the cell
     *
     * @return the x coordinate of the cell
     */
    public int getX () {
        return this.x;
    }

    /**
     * Get the y coordinate of the cell
     *
     * @return the y coordinate of the cell
     */
    public int getY () {
        return this.y;
    }

    /**
     * Get the state of the cell
     *
     * @return the state of the cell
     */
    public State getState () {
        return this.state;
    }

    /**
     * Get the age of the cell
     *
     * @return the age of the cell
     */
    public int getAge () {
        return this.age;
    }

    // Setters

    /**
     * Set the state of the cell
     *
     * @param state - the state of the cell
     */
    public void setState (State state) {
        this.age = 0;
        this.state = state;
    }

    /**
     * Set the age of the cell
     *
     * @param age - the age of the cell
     */
    public void setAge (int age) {
        this.age = age;
    }

    /**
     * Increment the age of the cell
     */
    public void incrementAge () {
        this.age++;
    }

    // Override

    /**
     * Get the string representation of the cell
     */
    @Override
    public String toString () {
        return this.state.toString();
    }
}
