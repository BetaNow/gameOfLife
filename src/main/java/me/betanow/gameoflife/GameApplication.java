package me.betanow.gameoflife;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import me.betanow.gameoflife.game.GameOfLife;

import java.io.IOException;
import java.util.Objects;

/**
 * The main application class
 */
public class GameApplication extends Application {

    private static GameOfLife game;

    /**
     * Start the application
     *
     * @param stage - the stage to start
     * @throws IOException - if the FXML file cannot be loaded
     */
    @Override
    public void start (Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("game-of-life.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        stage.setTitle("Game Of Life");
        stage.setScene(scene);
        stage.show();

        // Load the CSS file
        String cssPath = Objects.requireNonNull(GameApplication.class.getResource("styles.css")).toExternalForm();
        scene.getStylesheets().add(cssPath);

        // Get GridPane from FXML
        GameController controller = fxmlLoader.getController();
        GridPane gridPane = controller.getGridPane();
        game = new GameOfLife(gridPane);
    }

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        launch();
    }

    /**
     * Get the game of life
     *
     * @return the game of life
     */
    public static GameOfLife getGame () {
        return game;
    }
}