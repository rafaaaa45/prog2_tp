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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ListConsultasAdmin implements Initializable {
    @FXML
    private ListView<String> consultas;
    @FXML
    private Button voltar;

    public static String consultaCurrente;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Repository repo;
        repo = Repository.getRepository();
        for (Consulta consulta : repo.getConsultas().values()) {
            if (consulta.getEstadoConsulta().equals(estadoConsulta.porConfirmar)){
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
    public void onVoltar(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
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
