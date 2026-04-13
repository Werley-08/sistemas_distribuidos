package model;

import interfaces.Admissivel;

public class Funcionario extends Colaborador implements Admissivel {

    public Funcionario(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void admitir() {
        System.out.println("Funcionário admitido: " + nome);
    }
}