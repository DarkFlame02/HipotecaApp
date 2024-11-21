package dad.hipoteca.ui;

import dad.hipoteca.api.HipotecaApi;
import dad.hipoteca.api.HipotecaResult;
import dad.hipoteca.model.Cuotas;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    // logic

    private final HipotecaApi hipotecaApi = new HipotecaApi();

    // model

    private final StringProperty calcularHipotecaCapital = new SimpleStringProperty();
    private final StringProperty calcularHipotecaIntereses = new SimpleStringProperty();
    private final StringProperty calcularHipotecaAños = new SimpleStringProperty();
    private final ListProperty<Cuotas> cuotas = new SimpleListProperty<>(FXCollections.observableArrayList());

    // view

    @FXML
    private TableView<Cuotas> cuotasTable;

    @FXML
    private TableColumn<Cuotas, Integer> numColumn;

    @FXML
    private TableColumn<Cuotas, Integer> añoColumn;

    @FXML
    private TableColumn<Cuotas, Integer> mesColumn;

    @FXML
    private TableColumn<Cuotas, Double> capInicialColumn;

    @FXML
    private TableColumn<Cuotas, Double> interesesColumn;

    @FXML
    private TableColumn<Cuotas, Double> capAmortColumn;

    @FXML
    private TableColumn<Cuotas, Double> coutaColumn;

    @FXML
    private TableColumn<Cuotas, Double> capPendColumn;

    @FXML
    private TextField interesText;

    @FXML
    private TextField añosText;

    @FXML
    private TextField capitalText;

    @FXML
    private BorderPane root;

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // cell value factories

        numColumn.setCellValueFactory(v -> v.getValue().numCuotaProperty().asObject());
        añoColumn.setCellValueFactory(v -> v.getValue().anyoCuotaProperty().asObject());
        mesColumn.setCellValueFactory(v -> v.getValue().mesCuotaProperty().asObject());
        capInicialColumn.setCellValueFactory(v -> v.getValue().capitalInicialProperty().asObject());
        interesesColumn.setCellValueFactory(v -> v.getValue().interesesProperty().asObject());
        capAmortColumn.setCellValueFactory(v -> v.getValue().capitalAmortizadoProperty().asObject());
        coutaColumn.setCellValueFactory(v -> v.getValue().cuotasProperty().asObject());
        capPendColumn.setCellValueFactory(v -> v.getValue().capitalPendienteProperty().asObject());

        // bindings

        cuotasTable.itemsProperty().bind(cuotas);
        calcularHipotecaCapital.bind(capitalText.textProperty());
        calcularHipotecaIntereses.bind(interesText.textProperty());
        calcularHipotecaAños.bind(añosText.textProperty());

        cuotasTable.refresh();
    }

    public BorderPane getRoot() {
        return root;
    }

    @FXML
    void onCalcularAction(ActionEvent event) {
        try {
            double capital = Double.parseDouble(calcularHipotecaCapital.get());
            double intereses = Double.parseDouble(calcularHipotecaIntereses.get());
            int años = Integer.parseInt(calcularHipotecaAños.get());
            HipotecaResult result = hipotecaApi.getCuotas(capital, intereses, años);

            List<Cuotas> cuotas = result.getCuotas()
                    .stream()
                    .map(Cuotas::new)
                    .toList();
            this.cuotas.setAll(cuotas);
            cuotasTable.refresh();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(root.getScene().getWindow());
            alert.setTitle("Error");
            alert.setHeaderText("Algo ha salido mal");
            alert.setContentText(e.getLocalizedMessage());
            alert.show();
        }
    }

}
