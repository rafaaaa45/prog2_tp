package com.example.prog2_4ano;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Button register;
    @FXML
    protected void onLoginClick(ActionEvent event) {
        boolean found = false;

        try{
            Repository repo;
            repo = Repository.getRepository();
            sessionData sd = new sessionData();


            if (username.getText().equals("admin") && password.getText().equals("admin")) {
                    found = true;
                    System.out.println("Login com Sucesso!");
                    Parent root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
                    Scene regCena = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(regCena);
                    stage.setTitle("Menu Admin");
                    stage.show();
                }
            for (Cliente cliente : repo.getClientes().values()) {
                if (username.getText().equalsIgnoreCase(cliente.getUsername()) && password.getText().equals(cliente.getPassword())) {
                    found = true;
                    sd.cliente = cliente;
                    System.out.println("Login com Sucesso!");
                    Parent root = FXMLLoader.load(getClass().getResource("menuCliente.fxml"));
                    Scene regCena = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(regCena);
                    stage.setTitle("Menu Cliente");
                    stage.show();
                }
            }
            for (donoEmpresa donoEmpresa : repo.getDonosEmpresa().values()) {
                if (username.getText().equalsIgnoreCase(donoEmpresa.getUsername()) && password.getText().equals(donoEmpresa.getPassword())) {
                    found = true;
                    sd.donoEmpresa = donoEmpresa;
                    System.out.println("Login com Sucesso!");




                    Parent root = FXMLLoader.load(getClass().getResource("menuDonoEmpresa.fxml"));
                    Scene regCena = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(regCena);
                    stage.setTitle("Menu Dono de Empresa");
                    stage.show();
                }
            }
            for (Administrador administrador : repo.getAdministradores().values()) {
                if (username.getText().equalsIgnoreCase(administrador.getUsername()) && password.getText().equals(administrador.getPassword())) {
                    found = true;
                    sd.administrador = administrador;
                    System.out.println("Login com Sucesso!");
                    Parent root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
                    Scene regCena = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(regCena);
                    stage.setTitle("Menu Administrador");
                    stage.show();
                }
            }
            for (Funcionario funcionario : repo.getFuncionarios().values()) {
                if (username.getText().equalsIgnoreCase(funcionario.getUsername()) && password.getText().equals(funcionario.getPassword())) {
                    found = true;
                    sd.funcionario = funcionario;
                    System.out.println("Login com Sucesso!");
                    Parent root = FXMLLoader.load(getClass().getResource("funcionarioMenu.fxml"));
                    Scene regCena = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(regCena);
                    stage.setTitle("Menu Funcionario");
                    stage.show();
                }
            }
            if(!found){
                Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
                alertDatInv.setTitle("Erro");
                alertDatInv.setHeaderText("Utilizador/Password Errada!");
                alertDatInv.show();
            }
        }
        catch(Exception e)
        {
            System.out.println("Erro na funcao verifyLogin! \n" + e);
        }
    }

    @FXML
    protected void onRegisterClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Registar");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}