import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class VotingServer {

    private static final int PORT = 12345;
    private static Map<String, Integer> votos = new ConcurrentHashMap<>();
    private static List<String> candidatos = new CopyOnWriteArrayList<>();
    private static boolean votacaoAberta = true;

    public static void main(String[] args) throws Exception {

        candidatos.add("Alice");
        candidatos.add("Bob");
        candidatos.add("Carlos");

        // Timer da votação (60 segundos)
        new Thread(() -> {
            try {
                Thread.sleep(60000);
                votacaoAberta = false;
                mostrarResultado();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor iniciado...");

        while (true) {
            Socket socket = serverSocket.accept();
            new ClientHandler(socket).start();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {

                // LOGIN
                out.println("Digite seu nome:");
                String usuario = in.readLine();

                out.println("Bem-vindo " + usuario);

                // ENVIA LISTA
                out.println("Candidatos:");
                for (String c : candidatos) {
                    out.println("- " + c);
                }

                if (!votacaoAberta) {
                    out.println("Votação encerrada.");
                    return;
                }

                // RECEBE VOTO
                out.println("Digite seu voto:");
                String voto = in.readLine();

                votos.merge(voto, 1, Integer::sum);

                out.println("Voto registrado!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void mostrarResultado() {
        System.out.println("\n=== RESULTADO ===");

        int total = votos.values().stream().mapToInt(Integer::intValue).sum();

        String vencedor = "";
        int max = 0;

        for (var entry : votos.entrySet()) {
            double perc = (entry.getValue() * 100.0) / total;
            System.out.println(entry.getKey() + ": " + perc + "%");

            if (entry.getValue() > max) {
                max = entry.getValue();
                vencedor = entry.getKey();
            }
        }

        System.out.println("Vencedor: " + vencedor);
    }
}