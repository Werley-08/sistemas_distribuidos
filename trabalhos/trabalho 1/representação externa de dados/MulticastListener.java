import java.net.*;

public class MulticastListener {

    public static void main(String[] args) throws Exception {

        MulticastSocket socket = new MulticastSocket(4446);
        InetAddress grupo = InetAddress.getByName("230.0.0.0");

        socket.joinGroup(grupo);

        byte[] buffer = new byte[256];

        while (true) {
            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
            socket.receive(pacote);

            String mensagem = new String(pacote.getData(), 0, pacote.getLength());
            System.out.println("NOTA: " + mensagem);
        }
    }
}