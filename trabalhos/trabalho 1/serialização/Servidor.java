import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        int porta = 12345;

        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Servidor rodando na porta " + porta);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado!");

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                // DESSERIALIZAÇÃO
                Request req = (Request) in.readObject();

                System.out.println("Recebido: " + req.getNome() + " - " + req.getValor());

                String respostaTexto = "Olá " + req.getNome() +
                        ", valor recebido: " + req.getValor();

                Response response = new Response(respostaTexto);

                // SERIALIZAÇÃO
                out.writeObject(response);
                out.flush();

                socket.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}