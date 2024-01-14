package com.example.prog2_4ano;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuDonoEmpresa {
    @FXML
    private Button criarEmpresa;
    @FXML
    private Button listEmpresas;
    @FXML
    private Button listFuncionarios;
    @FXML
    private Button criarConsultorio;
    @FXML
    private Button listConsultorios;
    @FXML
    private Button listConsultasEmpresa;
    @FXML
    private Button criarFuncionario;
    @FXML
    private Button logout;

    @FXML
    protected void oncriarEmpresa(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("criarEmpresa.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Criar Empresa");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onlistEmpresa(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("listEmpresas.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Empresas");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onlistConsultorio(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("listConsultorios.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Empresas");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    protected void oncriarConsultorio(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("criarConsultorio.fxml"));
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
    protected void oncriarFuncionario(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("criarFuncionario.fxml"));
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
    protected void onlistFuncionario(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("listFuncionarios.fxml"));
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
    protected void onlistConsultasEmpresa(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("listConsultasEmpresa.fxml"));
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
    protected void logout(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Login");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
