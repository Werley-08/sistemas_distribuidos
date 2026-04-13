import java.net.*;

public class AdminMulticast {

    public static void main(String[] args) throws Exception {

        InetAddress grupo = InetAddress.getByName("230.0.0.0");
        int porta = 4446;

        MulticastSocket socket = new MulticastSocket();

        String mensagem = "A votação encerra em breve!";
        DatagramPacket pacote = new DatagramPacket(
                mensagem.getBytes(),
                mensagem.length(),
                grupo,
                porta
        );

        socket.send(pacote);
        socket.close();
    }
}