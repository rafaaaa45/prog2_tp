package com.example.prog2_4ano;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consulta implements Serializable {
    private tipoConsulta tipoConsulta;
    private String preco;
    private Funcionario funcionario;
    private String data;
    private String hora;
    private estadoConsulta estadoConsulta;
    private List<Servico> servicos;

    public Consulta() {
        this.servicos = new ArrayList<>();
    };

    public List<Servico> getServicos() {
        return servicos;
    }

    public com.example.prog2_4ano.tipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(com.example.prog2_4ano.tipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public com.example.prog2_4ano.estadoConsulta getEstadoConsulta() {
        return estadoConsulta;
    }

    public void setEstadoConsulta(com.example.prog2_4ano.estadoConsulta estadoConsulta) {
        this.estadoConsulta = estadoConsulta;
    }
}
