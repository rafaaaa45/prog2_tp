package com.example.prog2_4ano;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Login extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("Current Directory: " + System.getProperty("user.dir"));
        String filePath = "C:\\Users\\hbast\\Desktop\\prog2_4ano\\project_state.ser";
        System.out.println("Deserialization File Path: " + new File(filePath).getAbsolutePath());

        Repository repository = Repository.getRepository();
        if (repository.getDonosEmpresa().isEmpty()) {
            // Deserialize only if the donosEmpresa map is empty
            Repository deserializedRepo = SerializationUtil.deserializeRepository(filePath);
            if (deserializedRepo != null) {
                repository.getDonosEmpresa().putAll(deserializedRepo.getDonosEmpresa());
                System.out.println("Deserialization successful. Size of donosEmpresa map: " + repository.getDonosEmpresa().size());

                repository.getClientes().putAll(deserializedRepo.getClientes());
                System.out.println("Deserialization successful. Size of Clientes map: " + repository.getClientes().size());

                repository.getEmpresas().putAll(deserializedRepo.getEmpresas());
                System.out.println("Deserialization successful. Size of Empresas map: " + repository.getEmpresas().size());

                repository.getConsultorios().putAll(deserializedRepo.getConsultorios());
                System.out.println("Deserialization successful. Size of Consultorios map: " + repository.getConsultorios().size());

                repository.getFuncionarios().putAll(deserializedRepo.getFuncionarios());
                System.out.println("Deserialization successful. Size of Funcionarios map: " + repository.getFuncionarios().size());

                repository.getConsultas().putAll(deserializedRepo.getConsultas()); // Add this line
                System.out.println("Deserialization successful. Size of Consultas map: " + repository.getConsultas().size());
            } else {
                System.out.println("Deserialization failed. Using existing Repository.");
            }
        } else {
            System.out.println("Repository is already initialized. Skipping deserialization.");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 450);
        stage.setTitle("DentalCare");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



