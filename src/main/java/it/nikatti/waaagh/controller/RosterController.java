package it.nikatti.waaagh.controller;

import it.nikatti.waaagh.model.RosterFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import lombok.Setter;

public class RosterController {

    // Setting the client-object in ClientViewController
    @Setter
    private RosterFile rosterFile;
    private Boolean playerTurn;

    ObservableList<String> phaseList =
            FXCollections.observableArrayList(
                    "Command Phase",
                    "Movement Phase",
                    "Shooting Phase",
                    "Charge Phase",
                    "Fight Phase"
            );

    @FXML
    private ToggleButton turn_toggle_button;

    @FXML
    private ComboBox phase_combobox;

    @FXML
    private ListView army_forces_list;

    @FXML
    public void initialize() {
        // Add a listener to handle toggle state changes
        turn_toggle_button.setOnAction(event -> handleToggle());
        turn_toggle_button.setSelected(true);
        phase_combobox.setItems(phaseList);
        phase_combobox.setValue(phaseList.get(0));

        
    }

    private void handleToggle() {
        if (turn_toggle_button.isSelected()) {
            playerTurn = true;
            turn_toggle_button.setText("Your Turn");
        } else {
            playerTurn = false;
            turn_toggle_button.setText("Enemy Turn");
        }
    }


}
