package stream;

import model.Colaborador;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ColaboradorOutputStream extends OutputStream {

    private Colaborador[] colaboradores;
    private int quantidade;
    private OutputStream out;

    public ColaboradorOutputStream(Colaborador[] colaboradores,
                                   int quantidade,
                                   OutputStream out) {
        if(quantidade > colaboradores.length)
            throw new IllegalArgumentException("quantidade maior que o array de colaboradores");
        this.colaboradores = colaboradores;
        this.quantidade = quantidade;
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    public void enviar() throws IOException {

        writeInt(quantidade);

        for (int i = 0; i < quantidade; i++) {
            Colaborador c = colaboradores[i];

            byte[] idBytes = String.valueOf(c.getId()).getBytes();
            byte[] nomeBytes = c.getNome().getBytes(StandardCharsets.UTF_8);
            byte[] salarioBytes = String.valueOf(c.getSalario()).getBytes();

            writeInt(idBytes.length);
            out.write(idBytes);

            writeInt(nomeBytes.length);
            out.write(nomeBytes);

            writeInt(salarioBytes.length);
            out.write(salarioBytes);
        }

        out.flush();
    }

    private void writeInt(int valor) throws IOException {
        out.write((valor >> 24) & 0xFF);
        out.write((valor >> 16) & 0xFF);
        out.write((valor >> 8) & 0xFF);
        out.write(valor & 0xFF);
    }
}