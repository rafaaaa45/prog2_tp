package com.example.prog2_4ano;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class CriarEmpresa {
    private boolean phoneStatus = false;
    @FXML
    private TextField nome;
    @FXML
    private TextField morada;
    @FXML
    private TextField localidade;
    @FXML
    private TextField telefone;
    @FXML
    private Button criarEmpresa;
    @FXML
    private Button voltar;
    @FXML
    private Text phoneError;



    @FXML
    void oncriarEmpresa(ActionEvent event) {
        if (phoneStatus == true) {
            Empresa empresa = new Empresa();
            empresa.setNome(nome.getText());
            empresa.setMorada(morada.getText());
            empresa.setLocalidade(localidade.getText());
            empresa.setTelefone(telefone.getText());
            empresa.setEstadoEmpresa(estadoEmpresa.ativada);
            EmpresaRepo.createEmpresa(empresa, sessionData.donoEmpresa);


            try {
                Parent root = FXMLLoader.load(getClass().getResource("menuDonoEmpresa.fxml"));
                Scene regCena = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(regCena);
                stage.setTitle("Dono Empresa");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else {
            Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
            alertDatInv.setTitle("Erro");
            alertDatInv.setHeaderText("Verifique os dados inseridos");
            alertDatInv.show();
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

    @FXML
    void verifyPhone(KeyEvent event) {
        String text = telefone.getText();
        if (text.matches("[0-9]*")) {
            phoneStatus = true;
            phoneError.setVisible(false);
            if (text.length() != 9) {
                phoneStatus = false;
                phoneError.setVisible(true);
            }
        } else {
            phoneStatus = false;
            phoneError.setVisible(true);
        }
    }
}
