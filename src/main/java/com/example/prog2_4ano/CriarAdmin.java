package com.example.prog2_4ano;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CriarAdmin {
    private boolean phoneStatus = false;
    private boolean nifStatus = false;
    private boolean ccStatus = false;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField nome;
    @FXML
    private TextField cc;
    @FXML
    private TextField nif;
    @FXML
    private TextField telefone;
    @FXML
    private TextField morada;
    @FXML
    private TextField localidade;
    @FXML
    private Button criarAdmin;
    @FXML
    private Button voltar;
    @FXML
    private Text phoneError;

    @FXML
    private Text nifError;
    @FXML
    private Text ccError;

    @FXML
    void oncriarAdmin(ActionEvent event) {
        if(phoneStatus == true && nifStatus == true && ccStatus == true) {
            Administrador admin = new Administrador();
            admin.setUsername(username.getText());
            admin.setPassword(password.getText());
            admin.setNome(nome.getText());
            admin.setCc(cc.getText());
            admin.setNif(nif.getText());
            admin.setTelefone(telefone.getText());
            admin.setMorada(morada.getText());
            admin.setLocalidade(localidade.getText());
            AdminRepo.createAdmin(admin);

            try {
                Parent root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
                Scene regCena = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(regCena);
                stage.setTitle("Admin");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
            alertDatInv.setTitle("Erro");
            alertDatInv.setHeaderText("Verifique os dados inseridos");
            alertDatInv.show();
        }
    }

    @FXML
    public void onVoltar(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
            Scene regCena = new Scene (root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Funcionario");
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

    @FXML
    void verifyNif(KeyEvent event) {
        String text = nif.getText();
        if (text.matches("[0-9]*")) {
            nifStatus = true;
            nifError.setVisible(false);
            if (text.length() != 9) {
                nifStatus = false;
                nifError.setVisible(true);
            }
        } else {
            nifStatus = false;
            nifError.setVisible(true);
        }
    }

    @FXML
    void verifyCC(KeyEvent event) {
        String text = cc.getText();
        if (text.matches("[0-9]*")) {
            ccStatus = true;
            ccError.setVisible(false);
            if (text.length() != 9) {
                ccStatus = false;
                ccError.setVisible(true);
            }
        } else {
            ccStatus = false;
            ccError.setVisible(true);
        }
    }
}
