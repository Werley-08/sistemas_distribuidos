package test;

import model.Colaborador;
import stream.ColaboradorInputStream;

import java.io.FileInputStream;

public class TesteInputArquivo {
    public static void main(String[] args) throws Exception {
        try (FileInputStream fis = new FileInputStream("colaboradores.dat")) {
            ColaboradorInputStream cis = new ColaboradorInputStream(fis);

            Colaborador[] lista = cis.lerTodos();

            System.out.println("=== DADOS RECEBIDOS ===");
            for (Colaborador c : lista) {
                System.out.println("ID: "      + c.getId());
                System.out.println("Nome: "    + c.getNome());
                System.out.println("Salário: " + c.getSalario());
                System.out.println("---");
            }
        }
    }
}