module me.betanow.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.betanow.gameoflife to javafx.fxml;
    exports me.betanow.gameoflife;
}