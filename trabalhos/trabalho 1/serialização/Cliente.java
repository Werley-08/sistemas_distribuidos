import java.io.*;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        String host = "localhost";
        int porta = 12345;

        try (Socket socket = new Socket(host, porta)) {

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            Request req = new Request(1, "João", 3000.0);

            // SERIALIZAÇÃO
            out.writeObject(req);
            out.flush();

            // DESSERIALIZAÇÃO
            Response response = (Response) in.readObject();

            System.out.println("Resposta do servidor: " + response.getMensagem());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}