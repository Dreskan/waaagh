package it.nikatti.waaagh.controller;

import it.nikatti.waaagh.model.RosterFile;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;

public class ScreenController {

    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;

    public ScreenController(Scene main) {
        this.main = main;
    }

    protected void addScreen(String name, Pane pane) {
        screenMap.put(name, pane);
    }

    protected void removeScreen(String name) {
        screenMap.remove(name);
    }

    protected void activateRosterView(String name, RosterFile rosterFile) {
        main.setRoot(screenMap.get(name));
        Stage stage = new Stage();
        stage.setScene(main);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml_example.fxml"));
        RosterController rosterController = new RosterController();
        rosterController.setRosterFile(rosterFile);
        fxmlLoader.setController(rosterController);
        stage.show();
    }

}
