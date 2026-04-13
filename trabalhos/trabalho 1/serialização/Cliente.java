import java.io.*;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        String host = "localhost";
        int porta = 12345;

        try (Socket socket = new Socket(host, porta)) {

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            Request req = new Request(1, "João", 3000.0);

            // SERIALIZAÇÃO (enviar)
            req.write(out);

            // DESERIALIZAÇÃO (receber resposta)
            Response response = Response.read(in);

            System.out.println("Resposta do servidor: " + response.getMensagem());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}