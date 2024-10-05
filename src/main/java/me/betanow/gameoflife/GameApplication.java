package me.betanow.gameoflife;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main application class
 */
public class GameApplication extends Application {
    /**
     * Start the application
     *
     * @param stage - the stage to start
     * @throws IOException - if the FXML file cannot be loaded
     */
    @Override
    public void start (Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("game-of-life.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Game Of Life");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        launch();
    }
}