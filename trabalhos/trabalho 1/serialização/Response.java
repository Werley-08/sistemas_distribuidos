import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Response {
    private String mensagem;

    public Response(String mensagem) {
        this.mensagem = mensagem;
    }

    // SERIALIZAÇÃO
    public void write(DataOutputStream out) throws IOException {
        out.writeUTF(mensagem);
    }

    // DESSERIALIZAÇÃO
    public static Response read(DataInputStream in) throws IOException {
        String msg = in.readUTF();
        return new Response(msg);
    }

    public String getMensagem() {
        return mensagem;
    }
}