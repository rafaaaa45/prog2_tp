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

public class ListDonosEmpresa implements Initializable {
    @FXML
    private ListView<String> donosEmpresa;
    @FXML
    private Button voltar;

    public static String donoEmpresaCurrente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Repository repo;
        repo = Repository.getRepository();
        for (donoEmpresa donoEmpresa : repo.getDonosEmpresa().values()) {
            donosEmpresa.getItems().addAll(donoEmpresa.getNome());

            donosEmpresa.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    donoEmpresaCurrente = donosEmpresa.getSelectionModel().getSelectedItem();
                }
            });
        }
    }

    @FXML
    public void onVoltar(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Admin");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
