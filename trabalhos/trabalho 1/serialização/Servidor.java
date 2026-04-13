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

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // DESERIALIZAÇÃO (receber request)
                Request req = Request.read(in);

                System.out.println("Recebido: " + req.getNome() + " - " + req.getValor());

                String respostaTexto = "Olá " + req.getNome() +
                        ", valor recebido: " + req.getValor();

                Response response = new Response(respostaTexto);

                // SERIALIZAÇÃO (enviar resposta)
                response.write(out);

                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}