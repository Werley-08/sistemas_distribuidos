package stream;

import model.Colaborador;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ColaboradorInputStream extends InputStream {

    private InputStream in;

    public ColaboradorInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        return in.read();
    }

    public Colaborador ler() throws IOException {

        int idSize = readInt();
        byte[] idBytes = in.readNBytes(idSize);

        int nomeSize = readInt();
        byte[] nomeBytes = in.readNBytes(nomeSize);

        int salarioSize = readInt();
        byte[] salarioBytes = in.readNBytes(salarioSize);

        int id = Integer.parseInt(new String(idBytes));
        String nome = new String(nomeBytes, StandardCharsets.UTF_8);
        double salario = Double.parseDouble(new String(salarioBytes));

        return new Colaborador(id, nome, salario);
    }

    private int readInt() throws IOException {
        return (in.read() << 24) |
                (in.read() << 16) |
                (in.read() << 8) |
                (in.read());
    }
}