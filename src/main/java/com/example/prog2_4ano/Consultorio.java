package com.example.prog2_4ano;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Consultorio implements Serializable {

    private String morada;
    private String localidade;
    private String telefone;
    private Empresa empresa;
    private List<Funcionario> funcionarios;




    private donoEmpresa createdByDonoEmpresa;


    public donoEmpresa getCreatedByDonoEmpresa() {
        return createdByDonoEmpresa;
    }

    public void setCreatedByDonoEmpresa(donoEmpresa createdByDonoEmpresa) {
        this.createdByDonoEmpresa = createdByDonoEmpresa;
    }







    public Consultorio() {
        this.funcionarios = new ArrayList<>();
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
