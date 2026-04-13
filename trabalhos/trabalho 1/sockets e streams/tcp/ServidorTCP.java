package tcp;

import model.Colaborador;
import stream.ColaboradorInputStream;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);

        Socket socket = server.accept();

        ColaboradorInputStream cis =
                new ColaboradorInputStream(socket.getInputStream());

        Colaborador c = cis.ler();

        System.out.println("Recebido: " + c.getNome());

        socket.close();
        server.close();
    }
}