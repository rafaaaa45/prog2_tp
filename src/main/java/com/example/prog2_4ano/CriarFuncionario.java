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

public class CriarFuncionario implements Initializable {
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
    private ChoiceBox<String> tipoFuncionario;
    @FXML
    private ChoiceBox<String> consultorio;
    @FXML
    private Button criarFuncionario;
    @FXML
    private Button voltar;
    @FXML
    private Text phoneError;

    @FXML
    private Text nifError;
    @FXML
    private Text ccError;

    @FXML
    void oncriarFuncionario(ActionEvent event) {
        if(phoneStatus == true && nifStatus == true && ccStatus == true) {
            Funcionario funcionario = new Funcionario();
            funcionario.setUsername(username.getText());
            funcionario.setPassword(password.getText());
            funcionario.setNome(nome.getText());
            funcionario.setCc(cc.getText());
            funcionario.setNif(nif.getText());
            funcionario.setTelefone(telefone.getText());
            funcionario.setMorada(morada.getText());
            funcionario.setLocalidade(localidade.getText());
            String telefone1 = consultorio.getValue().toString();
            for (Consultorio consultorio1 : Repository.getRepository().getConsultorios().values()) {
                if (consultorio1.getTelefone().equals(telefone1)) {
                    FuncionarioRepo.createFuncionario(funcionario, consultorio1, sessionData.donoEmpresa);
                }
            }


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
        }else{
        Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
        alertDatInv.setTitle("Erro");
        alertDatInv.setHeaderText("Verifique os dados inseridos");
        alertDatInv.show();
    }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        donoEmpresa donoEmpresa = new donoEmpresa();
        donoEmpresa.setNome(sessionData.donoEmpresa.getNome());
        for(Consultorio consultorio1 : Repository.getRepository().getConsultorios().values()) {
            if(consultorio1.getEmpresa().getDonoEmpresa().getNome().equals(donoEmpresa.getNome()))
                consultorio.getItems().addAll(consultorio1.getTelefone());
        }
        tipoFuncionario.getItems().addAll("dentistas", "enfermeiros", "auxiliares", "secretariado");
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
