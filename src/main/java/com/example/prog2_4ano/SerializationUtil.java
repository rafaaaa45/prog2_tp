package com.example.prog2_4ano;
import java.io.*;

public class SerializationUtil {
    public static void serializeRepository(Repository repository, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(repository);
            System.out.println("Repository serialized and saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Repository deserializeRepository(String fileName) {
        try {
            File file = new File(fileName);
            System.out.println("Deserialization File Path: " + file.getAbsolutePath());

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Repository repository = (Repository) ois.readObject();
                System.out.println("Repository deserialized successfully!");
                return repository;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static void printRepositoryState(Repository repository) {
        System.out.println("Repository State:");
        System.out.println("Clientes: " + repository.getClientes().size());
        System.out.println("Donos Empresa: " + repository.getDonosEmpresa().size());
        // Add similar lines for other entities
    }
}
