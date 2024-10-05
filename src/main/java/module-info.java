module me.betanow.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.betanow.gameoflife to javafx.fxml;
    exports me.betanow.gameoflife;
    exports me.betanow.gameoflife.controllers;
    opens me.betanow.gameoflife.controllers to javafx.fxml;
}