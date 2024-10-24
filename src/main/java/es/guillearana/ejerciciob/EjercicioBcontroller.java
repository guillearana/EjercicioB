package es.guillearana.ejerciciob;  // Define el paquete del controlador, útil para la organización del proyecto.

import es.guillearana.model.Persona;  // Importa la clase Persona que representa el modelo de datos.
import javafx.collections.FXCollections;  // Importa utilidades para manejar listas observables en JavaFX.
import javafx.collections.ObservableList;  // Una lista que puede observar cambios y reflejarlos en la UI.
import javafx.event.ActionEvent;  // Para manejar eventos de la interfaz, como clics de botones.
import javafx.fxml.FXML;  // Para enlazar elementos definidos en el archivo FXML con el código Java.
import javafx.geometry.Pos;  // Clase para definir posiciones y alineaciones de nodos.
import javafx.scene.control.Alert;  // Para mostrar cuadros de diálogo emergentes.
import javafx.scene.control.Button;  // Un botón en JavaFX.
import javafx.scene.control.TableCell;  // Representa una celda en una tabla.
import javafx.scene.control.TableColumn;  // Representa una columna de una tabla en JavaFX.
import javafx.scene.control.TableView;  // Representa la tabla completa en JavaFX.
import javafx.scene.control.TextField;  // Un campo de texto para la entrada de datos.
import javafx.scene.control.Alert.AlertType;  // Para especificar el tipo de alerta (información, error, etc.).
import javafx.scene.control.cell.PropertyValueFactory;  // Para enlazar los datos con las columnas de la tabla.

/**
 * Controlador para la interfaz de usuario del Ejercicio B.
 * Este controlador permite gestionar una lista de personas, incluyendo la
 * inicialización de la vista, la gestión de eventos de los botones y la
 * validación de los datos de entrada.
 */
public class EjercicioBcontroller {

    /** Botón para agregar una persona a la tabla. */
    @FXML
    private Button btnAgregar;

    /** Columna de la tabla que muestra los apellidos de una persona. */
    @FXML
    private TableColumn<Persona, String> colApellidos;

    /** Lista observable que contendrá las personas agregadas a la tabla. */
    private ObservableList<Persona> personas;

    /** Columna que mostrará la edad de las personas. */
    @FXML
    private TableColumn<Persona, Integer> colEdad;

    /** Columna que mostrará el nombre de las personas. */
    @FXML
    private TableColumn<Persona, String> colNombre;

    /** La tabla que contendrá los datos de las personas. */
    @FXML
    private TableView<Persona> tableInfo;

    /** Campo de texto donde se ingresan los apellidos. */
    @FXML
    private TextField tfApellidos;

    /** Campo de texto donde se ingresa la edad. */
    @FXML
    private TextField tfEdad;

    /** Campo de texto donde se ingresa el nombre. */
    @FXML
    private TextField tfNombre;

    /**
     * Constructor de la clase.
     * Este constructor no realiza ninguna acción en este caso,
     * pero puede ser útil para inicializar variables si es necesario en el futuro.
     */
    public EjercicioBcontroller() {
    }

    /**
     * Método que se ejecuta automáticamente al cargar la interfaz.
     * Este método inicializa la lista de personas y configura las columnas
     * de la tabla para que muestren los datos correspondientes de la clase Persona.
     */
    @FXML
    void initialize() {
        this.personas = FXCollections.observableArrayList();  // Inicializa la lista de personas como observable.

        // Configura la columna 'Nombre' para que muestre la propiedad 'nombre' de la clase Persona.
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        // Configura la columna 'Apellidos' para que muestre la propiedad 'apellidos' de la clase Persona.
        this.colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));

        // Configura la columna 'Edad' para que muestre la propiedad 'edad' de la clase Persona.
        this.colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        // Personaliza las celdas de la columna 'Edad' para que los números aparezcan alineados a la derecha.
        this.colEdad.setCellFactory((col) -> {
            TableCell<Persona, Integer> cell = new TableCell<Persona, Integer>() {
                @Override
                public void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);  // Llama al método de la superclase.
                    this.setText(null);  // Limpia el texto anterior.
                    this.setGraphic(null);  // Limpia el contenido gráfico anterior.
                    if (!empty) {  // Si la celda no está vacía, muestra el valor de 'item'.
                        this.setText(Integer.toString(item));  // Convierte el valor de edad en texto.
                    }
                }
            };
            cell.setAlignment(Pos.CENTER_RIGHT);  // Alinea el contenido de la celda a la derecha.
            return cell;  // Devuelve la celda personalizada.
        });
    }

    /**
     * Método que se ejecuta cuando el usuario hace clic en el botón "Agregar".
     * Este método valida los campos de entrada y agrega una nueva persona a la tabla
     * si los datos son válidos. En caso de errores, se muestran alertas con los mensajes correspondientes.
     *
     * @param event El evento generado por el clic del botón.
     */
    @FXML
    void accionAceptar(ActionEvent event) {
        // Crea un StringBuilder para acumular los errores.
        StringBuilder errores = new StringBuilder();

        // Obtiene el texto del campo 'Nombre'.
        String nombre = this.tfNombre.getText();
        if (nombre.isEmpty()) {  // Verifica si el campo 'Nombre' está vacío.
            errores.append("El campo Nombre es obligatorio\n");  // Agrega un mensaje de error si está vacío.
        }

        // Obtiene el texto del campo 'Apellidos'.
        String apellidos = this.tfApellidos.getText();
        if (apellidos.isEmpty()) {  // Verifica si el campo 'Apellidos' está vacío.
            errores.append("El campo Apellidos es obligatorio\n");  // Agrega un mensaje de error si está vacío.
        }

        // Inicializa la variable edad.
        int edad = 0;
        if (tfEdad.getText().isEmpty()) {  // Verifica si el campo 'Edad' está vacío.
            errores.append("El campo Edad es obligatorio\n");  // Agrega un mensaje de error si está vacío.
        } else {
            try {
                // Intenta convertir el texto en un número.
                edad = Integer.parseInt(this.tfEdad.getText());
            } catch (NumberFormatException e) {  // Captura el error si la conversión falla.
                errores.append("La edad tiene que ser numérica\n");  // Agrega un mensaje de error si no es un número.
            }
        }

        // Si no hay errores, se procede a agregar la persona.
        if (errores.isEmpty()) {
            Persona p = new Persona(nombre, apellidos, edad);  // Crea un nuevo objeto Persona con los datos ingresados.
            Alert ventanaEmergente;  // Declara la alerta que se mostrará al usuario.

            // Si la persona no está ya en la lista, se añade.
            if (!this.personas.contains(p)) {
                this.personas.add(p);  // Agrega la nueva persona a la lista observable.

                // Crea una alerta de información para indicar que la persona se agregó correctamente.
                ventanaEmergente = new Alert(AlertType.INFORMATION);
                ventanaEmergente.setTitle("Información");
                ventanaEmergente.setContentText("Persona añadida correctamente");
                ventanaEmergente.setHeaderText(null);  // Sin encabezado.

                // Muestra la alerta al usuario.
                ventanaEmergente.show();

                // Actualiza la tabla con la nueva lista de personas.
                this.tableInfo.setItems(this.personas);
                this.tableInfo.refresh();  // Refresca la tabla para que muestre los datos actualizados.

                // Limpia los campos de texto después de agregar la persona
                this.tfNombre.clear();
                this.tfApellidos.clear();
                this.tfEdad.clear();
            } else {
                // Si la persona ya está en la lista, muestra un mensaje de error.
                ventanaEmergente = new Alert(AlertType.ERROR);
                ventanaEmergente.setTitle("ERROR");
                ventanaEmergente.setContentText("Esa persona ya existe");
                ventanaEmergente.setHeaderText(null);  // Sin encabezado.

                ventanaEmergente.show();  // Muestra la alerta de error.
            }
        } else {
            // Si hay errores, muestra todos los mensajes de error acumulados.
            Alert ventanaEmergente = new Alert(AlertType.ERROR);
            ventanaEmergente.setTitle("ERROR");
            ventanaEmergente.setContentText(String.valueOf(errores));  // Muestra los errores acumulados.
            ventanaEmergente.setHeaderText(null);  // Sin encabezado.

            ventanaEmergente.show();  // Muestra la alerta de error.
        }
    }

}
