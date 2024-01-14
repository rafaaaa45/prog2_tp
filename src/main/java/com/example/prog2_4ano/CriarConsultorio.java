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

public class CriarConsultorio implements Initializable {
    private boolean phoneStatus = false;
    @FXML
    private ChoiceBox<String> empresa;
    @FXML
    private TextField morada;
    @FXML
    private TextField localidade;
    @FXML
    private TextField telefone;
    @FXML
    private Button criarConsultorio;
    @FXML
    private Button voltar;
    @FXML
    private Text phoneError;

    @FXML
    void onCriarConsultorio(ActionEvent event) {
        if(phoneStatus == true) {
            Consultorio consultorio = new Consultorio();
            consultorio.setMorada(morada.getText());
            consultorio.setLocalidade(localidade.getText());
            consultorio.setTelefone(telefone.getText());
            String nome = empresa.getValue().toString();
            for (Empresa empresa1 : Repository.getRepository().getEmpresas().values()) {
                if (empresa1.getNome().equals(nome)) {
                    ConsultorioRepo.createConsultorio(consultorio, empresa1, sessionData.donoEmpresa);
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
        }else {
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
        for(Empresa empresa1 : Repository.getRepository().getEmpresas().values()) {
            if(empresa1.getDonoEmpresa().getNome().equals(donoEmpresa.getNome()))
                empresa.getItems().addAll(empresa1.getNome());
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
