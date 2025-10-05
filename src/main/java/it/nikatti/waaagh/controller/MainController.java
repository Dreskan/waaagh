package it.nikatti.waaagh.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.nikatti.waaagh.model.RosterFile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;

public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @FXML
    private Label army_file_locaton;

    @FXML
    protected void onDragOver(DragEvent dragEvent) {
        if (dragEvent.getDragboard().hasFiles()) {
            /* allow for both copying and moving, whatever user chooses */
            dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        dragEvent.consume();
    }

    @FXML
    protected void onDragDropped(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            //Parse JsonFile and open main window
            log.info("Drop Successful");
            System.out.println("Drop Successful");
            army_file_locaton.setDisable(false);
            army_file_locaton.setText(db.getFiles().toString());

            //Add spinner as Json is processed

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            RosterFile roster;
            try {
                File rosterFile = new File(db.getFiles().getFirst().toString());
                roster = mapper.readValue(rosterFile, RosterFile.class);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.println("Parse Successful");
            success = true;

            /* let the source know whether the string was successfully
             * transferred and used */
            dragEvent.setDropCompleted(success);

            dragEvent.consume();
            Parent root = null;
            try {
                URL mainViewUrl = new File("src/main/resources/it/nikatti/waaagh/main-view.fxml").toURI().toURL();
                root = FXMLLoader.load(mainViewUrl);

                ScreenController screenController = new ScreenController(new Scene(root));

                URL rosterViewUrl = new File("src/main/resources/it/nikatti/waaagh/roster-view.fxml").toURI().toURL();
                screenController.addScreen("roster", FXMLLoader.load(rosterViewUrl));
                Stage mainStage = (Stage) army_file_locaton.getScene().getWindow();
                mainStage.close();
                screenController.activateRosterView("roster", roster);

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}