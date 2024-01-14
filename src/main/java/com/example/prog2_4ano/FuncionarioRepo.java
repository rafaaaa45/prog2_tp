package com.example.prog2_4ano;

public class FuncionarioRepo {
    public static void createFuncionario(Funcionario funcionario, Consultorio consultorio, donoEmpresa createdByDonoEmpresa) {
        funcionario.setConsultorio(consultorio);
        funcionario.setCreatedByDonoEmpresa(createdByDonoEmpresa); // Set the createdByDonoEmpresa
        Repository.getRepository().getFuncionarios().put(funcionario.getNome(), funcionario);
        Repository.getRepository().getConsultorios().get(consultorio.getTelefone()).getFuncionarios().add(funcionario);
        System.out.println("Funcionario criado com sucesso!!!");
        SerializationUtil.serializeRepository(Repository.getRepository(), "project_state.ser");
    }
}
