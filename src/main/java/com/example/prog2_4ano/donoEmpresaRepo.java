package com.example.prog2_4ano;

public class donoEmpresaRepo {
    public static void createCompanyOwner(donoEmpresa donoEmpresa) {
        Repository repository = Repository.getRepository();
        repository.getDonosEmpresa().put(donoEmpresa.getUsername(), donoEmpresa);
        System.out.println("Dono Empresa criado com sucesso!!!");

        // Serialize the data after registration
        SerializationUtil.serializeRepository(repository, "project_state.ser");
    }
}

