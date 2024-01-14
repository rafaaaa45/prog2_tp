package com.example.prog2_4ano;

public class ServicoRepo {
    public static void createServico(Consulta consulta, Servico servico){
        servico.setConsulta(consulta);
        Repository.getRepository().getServicos().put(servico.getPreco(), servico);
        Repository.getRepository().getConsultas().get(servico.getConsulta()).getServicos().add(servico);
        System.out.println("Funcionario criado com sucesso!!!");
    }
}
