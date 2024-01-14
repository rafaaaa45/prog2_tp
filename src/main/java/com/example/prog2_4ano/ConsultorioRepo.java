package com.example.prog2_4ano;

public class ConsultorioRepo {
    public static void createConsultorio(Consultorio consultorio, Empresa empresa, donoEmpresa createdByDonoEmpresa) {
        consultorio.setEmpresa(empresa);
        consultorio.setCreatedByDonoEmpresa(createdByDonoEmpresa);
        Repository.getRepository().getConsultorios().put(consultorio.getTelefone(), consultorio);
        Repository.getRepository().getEmpresas().get(empresa.getNome()).getConsultorios().add(consultorio);
        System.out.println("Consultorio criado com sucesso!!!");
        SerializationUtil.serializeRepository(Repository.getRepository(), "project_state.ser");
    }
}
