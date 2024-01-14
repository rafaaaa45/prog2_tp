package com.example.prog2_4ano;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MarcarConsulta implements Initializable {
    @FXML
    private TextField data;
    @FXML
    private TextField hora;
    @FXML
    private ChoiceBox tipoConsulta;
    @FXML
    private ChoiceBox consultorio;
    @FXML
    private ChoiceBox funcionario;
    @FXML
    private Button marcarConsulta;
    @FXML
    private Button voltar;


    @FXML
    void onmarcarConsulta(ActionEvent event) {
        Consulta consulta = new Consulta();
        if (tipoConsulta.getValue().equals("consultaGeral")){
            consulta.setPreco("15");
        }else if (tipoConsulta.getValue().equals("limpezaDentes")) {
            consulta.setPreco("20");
        }else {
            consulta.setPreco("35");
        }
        consulta.setEstadoConsulta(estadoConsulta.porConfirmar);
        consulta.setData(data.getText());
        consulta.setHora(hora.getText());
        String nome = funcionario.getValue().toString();
        for(Funcionario funcionario1 : Repository.getRepository().getFuncionarios().values()) {
            if(funcionario1.getNome().equals(nome)){
                ConsultaRepo.createConsulta(funcionario1, consulta);
            }
        }


        try {
            Parent root = FXMLLoader.load(getClass().getResource("menuCliente.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Cliente");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipoConsulta.getItems().addAll("consultaGeral", "limpezaDentes", "destartarizacao");

        // Show all available consultorios
        for (Consultorio consultorio1 : Repository.getRepository().getConsultorios().values()) {
            consultorio.getItems().addAll(consultorio1.getTelefone());
        }

        // Set up a listener for the selected consultorio
        consultorio.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Clear existing items in the funcionario ChoiceBox
            funcionario.getItems().clear();

            // Show only funcionarios from the selected consultorio
            for (Funcionario funcionario1 : Repository.getRepository().getFuncionarios().values()) {
                if (funcionario1.getConsultorio().getTelefone().equals(newValue)) {
                    funcionario.getItems().addAll(funcionario1.getNome());
                }
            }
        });
    }


    @FXML
    protected void onVoltar(ActionEvent event) {
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
