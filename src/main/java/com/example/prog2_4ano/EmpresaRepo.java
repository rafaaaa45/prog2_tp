package com.example.prog2_4ano;

public class EmpresaRepo {
    public static void createEmpresa(Empresa empresa, donoEmpresa loggedInDonoEmpresa){
        Repository repository = Repository.getRepository();

        if (loggedInDonoEmpresa != null) {
            empresa.setDonoEmpresa(loggedInDonoEmpresa);
            empresa.setCreatedByDonoEmpresa(loggedInDonoEmpresa); // Set the createdByDonoEmpresa
            repository.getEmpresas().put(empresa.getNome(), empresa);
            loggedInDonoEmpresa.getEmpresas().add(empresa);
            System.out.println("Empresa criada com sucesso!!!");

            // Serialize the data after creating the empresa
            SerializationUtil.serializeRepository(repository, "project_state.ser");
        } else {
            System.out.println("Error: No logged-in donoEmpresa found.");
        }
    }
}

