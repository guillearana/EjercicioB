package es.guillearana.ejerciciob;

import es.guillearana.model.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;


public class EjercicioBcontroller {
    @FXML
    private Button btnAgregar;
    @FXML
    private TableColumn<Persona, String> colApellidos;
    private ObservableList<Persona> personas;
    @FXML
    private TableColumn<Persona, Integer> colEdad;
    @FXML
    private TableColumn<Persona, String> colNombre;
    @FXML
    private TableView<Persona> tableInfo;
    @FXML
    private TextField tfApellidos;
    @FXML
    private TextField tfEdad;
    @FXML
    private TextField tfNombre;

    public EjercicioBcontroller() {
    }

    @FXML
    void initialize() {
        this.personas = FXCollections.observableArrayList();
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory("edad"));
        this.colEdad.setCellFactory((col) -> {
            TableCell<Persona, Integer> cell = new TableCell<Persona, Integer>() {
                public void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText((String)null);
                    this.setGraphic((Node)null);
                    if (!empty) {
                        this.setText(Integer.toString(item));
                    }

                }
            };
            cell.setAlignment(Pos.CENTER_RIGHT);
            return cell;
        });
    }

    @FXML
    void accionAceptar(ActionEvent event) {
        String errores = "";
        String nombre = this.tfNombre.getText();
        if (nombre.isEmpty()) {
            errores = errores + "El campo Nombre es obligatorio\n";
        }

        String apellidos = this.tfApellidos.getText();
        if (apellidos.isEmpty()) {
            errores = errores + "El campo Apellidos es obligatorio\n";
        }

        int edad = 0;
        if (tfEdad.getText().isEmpty()) {
            errores = errores + "El campo edad es obligatorio\n";
        } else {
            try {
                edad = Integer.parseInt(this.tfEdad.getText());

            } catch (NumberFormatException var9) {
                errores = errores + "La edad tiene que ser numerica\n";
            }
        }

        if (errores.isEmpty()) {
            Persona p = new Persona(nombre, apellidos, edad);
            Alert ventanaEmergente;
            Button ocultarBtn;
            if (!this.personas.contains(p)) {
                this.personas.add(p);
                ventanaEmergente = new Alert(AlertType.INFORMATION);
                ventanaEmergente.setTitle("info");
                ventanaEmergente.setContentText("Persona añadida correctamente");
                ocultarBtn = new Button("Aceptar");
                ocultarBtn.setOnAction((e) -> {
                    ventanaEmergente.hide();
                });
                ventanaEmergente.show();
                this.tableInfo.setItems(this.personas);
                this.tableInfo.refresh();
            } else {
                ventanaEmergente = new Alert(AlertType.ERROR);
                ventanaEmergente.setTitle("ERROR");
                ventanaEmergente.setContentText("Esa persona ya existe");
                ventanaEmergente.setHeaderText(null);
                ocultarBtn = new Button("Aceptar");
                ocultarBtn.setOnAction((e) -> {
                    ventanaEmergente.hide();
                });
                ventanaEmergente.show();
            }
        } else {
            Alert ventanaEmergente = new Alert(AlertType.ERROR);
            ventanaEmergente.setTitle("ERROR");
            ventanaEmergente.setContentText(errores);
            Button ocultarBtn = new Button("Aceptar");
            ventanaEmergente.setHeaderText(null);
            ocultarBtn.setOnAction((e) -> {
                ventanaEmergente.hide();
            });
            ventanaEmergente.show();
        }

    }
}