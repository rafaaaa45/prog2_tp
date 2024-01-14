package com.example.prog2_4ano;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminMenu {
    @FXML
    private Button criarAdmin;
    @FXML
    private Button listDonosEmpresa;
    @FXML
    private Button listClientes;
    @FXML
    private Button listEmpresas;
    @FXML
    private Button listConsultorios;
    @FXML
    private Button listFuncionarios;
    @FXML
    private Button listConsultas;
    @FXML
    private Button logout;


    @FXML
    protected void onCriarAdmin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("criarAdmin.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Donos Empresa");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onlistDonosEmpresa(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("listDonosEmpresa.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Donos Empresa");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onlistClientes(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("listClientes.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Clientes");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onlistEmpresas(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("listEmpresasAdmin.fxml"));
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
    protected void onlistConsultorios(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("listConsultoriosAdmin.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Consultorios");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onlistFuncionarios(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("listFuncionariosAdmin.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Funcionarios");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onlistConsultas(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("listConsultasAdmin.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Consultas");
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
            stage.setTitle("Login");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
