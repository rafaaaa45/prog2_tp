package com.example.prog2_4ano;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ListConsultas implements Initializable {
    @FXML
    private ListView<String> consultas;
    @FXML
    private Button confirmarConsulta;
    @FXML
    private Button anularConsulta;
    @FXML
    private Button voltar;

    public static String consultaCurrente;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Repository repo = Repository.getRepository();
        for (Consulta consulta : repo.getConsultas().values()) {
            Funcionario funcionario = consulta.getFuncionario();
            if (consulta.getEstadoConsulta().equals(estadoConsulta.porConfirmar) &&
                    funcionario.getNome().equals(sessionData.funcionario.getNome())) {
                consultas.getItems().addAll(consulta.getData());
            }
        }

        consultas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                consultaCurrente = consultas.getSelectionModel().getSelectedItem();
            }
        });
    }

    @FXML
    public void onConfirmarConsulta() {
        for (Consulta consulta : Repository.getRepository().getConsultas().values()) {
            if (consulta.getFuncionario().getNome().equals(sessionData.funcionario.getNome()) && consulta.getData().equals(consultas.getSelectionModel().getSelectedItem())) {
                consulta.setEstadoConsulta(estadoConsulta.marcada);
            }
        }
    }

    @FXML
    public void onAnularConsulta() {
        for (Consulta consulta : Repository.getRepository().getConsultas().values()) {
            if (consulta.getFuncionario().getNome().equals(sessionData.funcionario.getNome()) && consulta.getData().equals(consultas.getSelectionModel().getSelectedItem())) {
                consulta.setEstadoConsulta(estadoConsulta.anulada);
            }
        }
    }

    @FXML
    public void onVoltar(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("funcionarioMenu.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Funcionario");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
