import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Request {
    private int id;
    private String nome;
    private double valor;

    public Request(int id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    // SERIALIZAÇÃO (empacotar)
    public void write(DataOutputStream out) throws IOException {
        out.writeInt(id);
        out.writeUTF(nome);
        out.writeDouble(valor);
    }

    // DESSERIALIZAÇÃO (desempacotar)
    public static Request read(DataInputStream in) throws IOException {
        int id = in.readInt();
        String nome = in.readUTF();
        double valor = in.readDouble();
        return new Request(id, nome, valor);
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}