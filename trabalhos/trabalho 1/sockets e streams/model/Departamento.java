package model;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nome;
    private List<Colaborador> colaboradores = new ArrayList<>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    public void adicionarColaborador(Colaborador c) {
        colaboradores.add(c);
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }
}