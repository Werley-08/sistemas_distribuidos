package test;

import model.Colaborador;
import stream.ColaboradorInputStream;

public class TesteInputConsole {

    public static void main(String[] args) throws Exception {

        System.out.println("Aguardando dados via System.in...");

        ColaboradorInputStream cis =
                new ColaboradorInputStream(System.in);

        Colaborador c = cis.ler();

        System.out.println("\n=== DADOS RECEBIDOS ===");
        System.out.println("ID: " + c.getId());
        System.out.println("Nome: " + c.getNome());
        System.out.println("Salário: " + c.getSalario());
    }
}