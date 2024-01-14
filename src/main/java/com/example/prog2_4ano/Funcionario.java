package com.example.prog2_4ano;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Funcionario implements Serializable {

    private String username;
    private String password;
    private String nome;
    private String cc;
    private String nif;
    private String telefone;
    private String morada;
    private String localidade;
    private tipoFuncionario tipoFuncionario;
    private Consultorio consultorio;
    private List<Consulta> consultas;



    private donoEmpresa createdByDonoEmpresa;

    public donoEmpresa getCreatedByDonoEmpresa() {
        return createdByDonoEmpresa;
    }

    public void setCreatedByDonoEmpresa(donoEmpresa createdByDonoEmpresa) {
        this.createdByDonoEmpresa = createdByDonoEmpresa;
    }





    public Funcionario() {
        this.consultas = new ArrayList<>();
    };

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public com.example.prog2_4ano.tipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(com.example.prog2_4ano.tipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }
}
