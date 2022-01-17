module com.medicinetracker.medicinetrackingapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.medicinetracker.medicinetrackingapp to javafx.fxml;
    exports com.medicinetracker.medicinetrackingapp;

}