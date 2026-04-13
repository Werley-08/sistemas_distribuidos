package tcp;

import model.Colaborador;
import model.Funcionario;
import stream.ColaboradorOutputStream;

import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12345);

        Colaborador[] lista = {
                new Funcionario(1, "Ana", 5000)
        };

        ColaboradorOutputStream cos =
                new ColaboradorOutputStream(lista, 1, socket.getOutputStream());

        cos.enviar();

        socket.close();
    }
}