module es.guillearana.ejerciciob {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.guillearana.ejerciciob to javafx.fxml;
    exports es.guillearana.ejerciciob;
}