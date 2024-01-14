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

public class FazerPagamento implements Initializable {
    @FXML
    private ListView<String> consultasConfirmadas;
    public static String consultaCurrente;
    @FXML
    private Button pagarConsulta;
    @FXML
    private Button cancelarConsulta;
    @FXML
    private Button voltar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Repository repo;
        repo = Repository.getRepository();
        for (Consulta consulta : repo.getConsultas().values()) {
            if (consulta.getEstadoConsulta().equals(estadoConsulta.marcada)){
                consultasConfirmadas.getItems().addAll(consulta.getData());
            }
        }

        consultasConfirmadas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                consultaCurrente = consultasConfirmadas.getSelectionModel().getSelectedItem();
            }
        });
    }

    @FXML
    public void onPagarConsulta(){
        for (Consulta consulta : Repository.getRepository().getConsultas().values()) {
            if (consulta.getFuncionario().equals(sessionData.funcionario.getNome()) && consulta.getData() == consultasConfirmadas.getSelectionModel().getSelectedItem()) {
                consulta.setEstadoConsulta(estadoConsulta.paga);
            }
        }
    }

    @FXML
    public void onCancelarConsulta(){
        for (Consulta consulta : Repository.getRepository().getConsultas().values()) {
            if (consulta.getFuncionario().equals(sessionData.funcionario.getNome()) && consulta.getData() == consultasConfirmadas.getSelectionModel().getSelectedItem()) {
                consulta.setEstadoConsulta(estadoConsulta.canceldada);
            }
        }
    }

    @FXML
    public void onVoltar(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("menuCliente.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Cliente");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
