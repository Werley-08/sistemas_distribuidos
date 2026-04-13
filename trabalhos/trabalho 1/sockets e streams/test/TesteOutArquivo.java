package test;

import model.Colaborador;
import model.Funcionario;
import stream.ColaboradorOutputStream;

import java.io.FileOutputStream;

public class TesteOutArquivo {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("colaboradores.dat");

        Colaborador[] lista = {
                new Funcionario(1, "Carlos", 4000)
        };

        ColaboradorOutputStream cos =
                new ColaboradorOutputStream(lista, 1, fos);

        cos.enviar();
        fos.close();
    }
}