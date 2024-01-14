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

public class ListEmpresas implements Initializable {
    @FXML
    private Button voltar;
    @FXML
    private Button criarConsultorio;
    @FXML
    private ListView<String> empresas;

    public static String empresaCurrente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Repository repo;
        repo = Repository.getRepository();
        donoEmpresa loggedInDonoEmpresa = sessionData.donoEmpresa;

        if (loggedInDonoEmpresa != null) {
            for (Empresa empresa : repo.getEmpresas().values()) {
                // Only display Empresas created by the logged-in donoEmpresa
                if (empresa.getCreatedByDonoEmpresa() == loggedInDonoEmpresa) {
                    empresas.getItems().addAll(empresa.getNome());
                }

                empresas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                        empresaCurrente = empresas.getSelectionModel().getSelectedItem();
                    }
                });
            }
        }
    }

    @FXML
    protected void oncriarConsultorio(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("criarConsultorio.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Dono Empresa");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onVoltar(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("menuDonoEmpresa.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Dono Empresa");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
