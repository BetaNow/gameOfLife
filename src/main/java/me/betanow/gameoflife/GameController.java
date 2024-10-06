package me.betanow.gameoflife;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

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
     * The generation
     */
    private int generation = 0;

    /**
     * The playing state
     */
    private boolean playing = false;

    /**
     * The timeline
     */
    private Timeline timeline;

    /**
     * Initialize the controller
     */
    @FXML
    public void initialize () {
        // Add a listener to the speed toggle group
        speed.selectedToggleProperty().addListener((observable, oldValue, newValue)->onSpeedChange(newValue));
    }

    /**
     * Handle the play button
     */
    @FXML
    public void play () {
        playing = !playing;
        playButton.setText(playing ? "Pause" : "Play");

        if (playing) {
            startTimeline();
        } else {
            if (timeline != null) {
                timeline.stop();
            }
        }
    }

    /**
     * Handle the clear button
     */
    @FXML
    public void clear () {
        GameApplication.getGame().clear();
        clearGenerationLabel();
    }

    /**
     * Handle the increment button
     */
    @FXML
    public void increment () {
        GameApplication.getGame().nextGeneration();
        updateGenerationLabel();
    }

    /**
     * Handle the randomize button
     */
    @FXML
    public void randomize () {
        GameApplication.getGame().randomize();
        clearGenerationLabel();
    }

    /**
     * Update the generation label
     */
    private void updateGenerationLabel () {
        generation++;
        generationLabel.setText("Generation: " + generation);
    }

    /**
     * Clear the generation label
     */
    private void clearGenerationLabel () {
        generation = 0;
        generationLabel.setText("Generation: 0");
    }

    /**
     * Start the timeline
     */
    private void startTimeline () {
        String speed = ((RadioButton) this.speed.getSelectedToggle()).getText();
        int delay = switch (speed) {
            case "Slow" -> 1000;
            case "Fast" -> 250;
            default -> 500;
        };

        if (timeline != null) {
            timeline.stop();
        }

        timeline = new Timeline(new KeyFrame(Duration.millis(delay), event->{
            GameApplication.getGame().nextGeneration();
            updateGenerationLabel();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Handle the speed change
     *
     * @param newValue - the new value
     */
    private void onSpeedChange (Toggle newValue) {
        if (newValue != null) {
            if (playing) {
                startTimeline();
            }
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