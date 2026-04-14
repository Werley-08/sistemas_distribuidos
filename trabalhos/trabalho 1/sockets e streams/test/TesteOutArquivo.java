package test;

import model.Colaborador;
import model.Estagiario;
import model.Funcionario;
import stream.ColaboradorOutputStream;

import java.io.FileOutputStream;

public class TesteOutArquivo {
    public static void main(String[] args) throws Exception {
        Colaborador[] lista = {
                new Funcionario(1, "Carlos", 4000),
                new Estagiario(2, "Maria", 1200)
        };

        try (FileOutputStream fos = new FileOutputStream("colaboradores.dat")) {
            ColaboradorOutputStream cos =
                    new ColaboradorOutputStream(lista, 2, fos);
            cos.enviar();
            System.out.println("Arquivo gerado com sucesso!");
        }
    }
}