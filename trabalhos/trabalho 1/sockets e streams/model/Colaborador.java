package model;

public class Colaborador {
    protected int id;
    protected String nome;
    protected double salario;

    public Colaborador(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getSalario() { return salario; }
}