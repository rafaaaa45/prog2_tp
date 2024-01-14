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

public class ListFuncionarios implements Initializable {
    @FXML
    private Button voltar;
    @FXML
    private ListView<String> funcionarios;

    public static String funcionarioCurrente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Repository repo = Repository.getRepository();
        donoEmpresa currentDonoEmpresa = sessionData.donoEmpresa;

        for (Funcionario funcionario : repo.getFuncionarios().values()) {
            // Check if the Funcionario was created by the currentDonoEmpresa
            if (funcionario.getConsultorio().getEmpresa().getDonoEmpresa().equals(currentDonoEmpresa)) {
                funcionarios.getItems().addAll(funcionario.getNome());

                funcionarios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                        funcionarioCurrente = funcionarios.getSelectionModel().getSelectedItem();
                    }
                });
            }
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
