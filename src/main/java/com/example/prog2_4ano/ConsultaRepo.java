package com.example.prog2_4ano;

public class ConsultaRepo {
    public static void createConsulta(Funcionario funcionario, Consulta consulta){
        consulta.setFuncionario(funcionario);
        Repository repository = Repository.getRepository();

        // Add the new Consulta to the repository
        repository.getConsultas().put(consulta.getData(), consulta);
        repository.getFuncionarios().get(funcionario.getNome()).getConsultas().add(consulta);

        System.out.println("Consulta criada com sucesso!!!");

        // Serialize the updated repository
        SerializationUtil.serializeRepository(repository, "project_state.ser");
    }
}
