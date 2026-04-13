package test;

import model.Colaborador;
import model.Estagiario;
import model.Funcionario;
import stream.ColaboradorOutputStream;

public class TesteOutConsole {
    public static void main(String[] args) throws Exception {
        Colaborador[] lista = {
                new Funcionario(1, "João", 3000),
                new Estagiario(2, "Maria", 1200)
        };

        ColaboradorOutputStream cos =
                new ColaboradorOutputStream(lista, 2, System.out);

        cos.enviar();
    }
}