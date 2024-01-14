package com.example.prog2_4ano;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuCliente {
    @FXML
    private Button marcarConsulta;
    @FXML
    private Button fazerPagamento;
    @FXML
    private Button logout;


    @FXML
    protected void onmarcarConsulta(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("marcarConsulta.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Criar Consultorio");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onfazerPagamento(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fazerPagamento.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Criar Consultorio");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onlogout(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Criar Consultorio");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
