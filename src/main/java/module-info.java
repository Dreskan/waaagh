module it.nikatti.waaagh {
    requires javafx.controls;
    requires javafx.fxml;

    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.slf4j;
    requires com.fasterxml.jackson.databind;
    requires static lombok;

    opens it.nikatti.waaagh to javafx.fxml;
    exports it.nikatti.waaagh;
    exports it.nikatti.waaagh.controller;
    exports it.nikatti.waaagh.util;
    exports it.nikatti.waaagh.model;
    opens it.nikatti.waaagh.controller to javafx.fxml;
}