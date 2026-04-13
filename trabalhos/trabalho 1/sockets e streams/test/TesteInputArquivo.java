package test;

import model.Colaborador;
import stream.ColaboradorInputStream;

import java.io.FileInputStream;

public class TesteInputArquivo {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("colaboradores.dat");

        ColaboradorInputStream cis =
                new ColaboradorInputStream(fis);

        Colaborador c = cis.ler();

        System.out.println("Nome: " + c.getNome());

        fis.close();
    }
}