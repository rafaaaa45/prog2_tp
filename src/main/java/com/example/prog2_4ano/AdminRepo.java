package com.example.prog2_4ano;

public class AdminRepo {
    public static void createAdmin(Administrador admin){
        Repository.getRepository().getAdministradores().put(admin.getNome(), admin);
        System.out.println("Admin criado com sucesso!!!");
    }
}
