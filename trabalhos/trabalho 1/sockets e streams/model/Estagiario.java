package model;

import interfaces.Admissivel;

public class Estagiario extends Colaborador implements Admissivel {

    public Estagiario(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void admitir() {
        System.out.println("Estagiário admitido: " + nome);
    }
}