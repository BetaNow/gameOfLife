module me.betanow.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens me.betanow.gameoflife to javafx.fxml;
    exports me.betanow.gameoflife;
    exports me.betanow.gameoflife.game;
}