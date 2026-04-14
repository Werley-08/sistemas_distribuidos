package test;

import model.Colaborador;
import stream.ColaboradorInputStream;
import stream.ColaboradorOutputStream;
import model.Funcionario;

public class TesteInputConsole {
    public static void main(String[] args) throws Exception {

        // Primeiro envia para System.out para simular dados no console
        Colaborador[] lista = {
                new Funcionario(1, "João", 3000)
        };

        System.out.println("=== ENVIANDO ===");
        ColaboradorOutputStream cos =
                new ColaboradorOutputStream(lista, 1, System.out);
        cos.enviar();

        // Lê do System.in
        System.out.println("\n=== AGUARDANDO DADOS VIA System.in ===");
        ColaboradorInputStream cis = new ColaboradorInputStream(System.in);

        Colaborador[] recebidos = cis.lerTodos();
        System.out.println("\n=== DADOS RECEBIDOS ===");
        for (Colaborador c : recebidos) {
            System.out.println("ID: "      + c.getId());
            System.out.println("Nome: "    + c.getNome());
            System.out.println("Salário: " + c.getSalario());
            System.out.println("---");
        }
    }
}