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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ListClientes implements Initializable {
    @FXML
    private ListView<String> clientes;

    @FXML
    private Button voltar;

    public static String clienteCurrente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Repository repo;
        repo = Repository.getRepository();
        for (Cliente cliente : repo.getClientes().values()) {
            clientes.getItems().addAll(cliente.getNome());

            clientes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    clienteCurrente = clientes.getSelectionModel().getSelectedItem();
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
