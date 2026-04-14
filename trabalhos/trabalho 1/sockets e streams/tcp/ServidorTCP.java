package tcp;

import model.Colaborador;
import stream.ColaboradorInputStream;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        while (true) {
            Socket socket = server.accept();

            ColaboradorInputStream cis =
                    new ColaboradorInputStream(socket.getInputStream());

            Colaborador[] lista = cis.lerTodos();
            System.out.println("Recebido: " + lista[0].getNome());

            socket.close();
        }

    }
}