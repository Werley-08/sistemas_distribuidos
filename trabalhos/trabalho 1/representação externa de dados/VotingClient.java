import java.io.*;
import java.net.*;

public class VotingClient {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 12345);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String resposta;

        while ((resposta = in.readLine()) != null) {
            System.out.println(resposta);

            if (resposta.contains("Digite")) {
                String input = teclado.readLine();
                out.println(input);
            }
        }

        socket.close();
    }
}