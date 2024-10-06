package me.betanow.gameoflife;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 * The controller for the setup view
 */
public class GameController {
    /**
     * The buttons
     */
    public Button playButton;
    public Button clearButton;
    public Button incrementButton;
    public Button randomizeButton;

    /**
     * The label
     */
    public Label generationLabel;

    /**
     * The speed toggle group
     */
    public ToggleGroup speed;

    /**
     * The grid pane
     */
    public GridPane gridPane;

    /**
     * Initialize the controller
     */
    @FXML
    public void initialize() {
        // Add a listener to the speed toggle group
        speed.selectedToggleProperty().addListener((observable, oldValue, newValue) -> onSpeedChange(newValue));
    }

    /**
     * Handle the play button
     */
    @FXML
    public void play () {
    }

    /**
     * Handle the clear button
     */
    @FXML
    public void clear () {
        GameApplication.getGame().clear();
    }

    /**
     * Handle the increment button
     */
    @FXML
    public void increment () {
    }

    /**
     * Handle the randomize button
     */
    @FXML
    public void randomize () {
        GameApplication.getGame().randomize();
    }

    /**
     * Update the generation label
     *
     * @param generation - the generation to update to
     */
    public void updateGenerationLabel (int generation) {
        generationLabel.setText("Generation: " + generation);
    }

    /**
     * Handle the speed change
     *
     * @param newValue - the new value
     */
    private void onSpeedChange(Toggle newValue) {
        if (newValue != null) {
            RadioButton selectedRadioButton = (RadioButton) newValue;
            String speed = selectedRadioButton.getText();
            System.out.println("Speed changed to: " + speed);
        }
    }

    /**
     * Get the grid pane
     *
     * @return the grid pane
     */
    public GridPane getGridPane () {
        return gridPane;
    }
}