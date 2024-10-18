package es.guillearana.ejerciciob;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionPersonas extends Application {

    public void start(Stage stage) throws IOException {
        // Cargar el archivo FXML que define la interfaz de usuario
        FXMLLoader fxmlLoader = new FXMLLoader(GestionPersonas.class.getResource("EjercicioB.fxml"));

        // Crear una nueva escena a partir del contenido cargado del FXML
        Scene scene = new Scene(fxmlLoader.load(), 967, 591);

        // Establecer el título de la ventana
        stage.setTitle("Encuesta");

        // Establecer dimensiones mínimas de la ventana
        stage.setMinWidth(550);
        stage.setMinHeight(550);

        // Establecer la escena en la ventana principal
        stage.setScene(scene);

        // Mostrar la ventana
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}