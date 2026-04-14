package stream;

import model.Colaborador;

import java.io.EOFException;
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

    /**
     * Lê todos os colaboradores do stream.
     * Espera que o stream comece com um cabeçalho (int)
     * indicando a quantidade de objetos.
     */
    public Colaborador[] lerTodos() throws IOException {
        int quantidade = readInt(); // lê cabeçalho
        Colaborador[] colaboradores = new Colaborador[quantidade];
        for (int i = 0; i < quantidade; i++) {
            colaboradores[i] = ler();
        }
        return colaboradores;
    }

    /**
     * Lê um único Colaborador do stream.
     * Formato esperado: [tamanho][bytes] para cada atributo.
     */
    public Colaborador ler() throws IOException {
        int idSize = readInt();
        byte[] idBytes = lerBytes(idSize);

        int nomeSize = readInt();
        byte[] nomeBytes = lerBytes(nomeSize);

        int salarioSize = readInt();
        byte[] salarioBytes = lerBytes(salarioSize);

        int id       = Integer.parseInt(new String(idBytes));
        String nome  = new String(nomeBytes, StandardCharsets.UTF_8);
        double salario = Double.parseDouble(new String(salarioBytes));

        return new Colaborador(id, nome, salario);
    }

    /**
     * Lê exatamente n bytes do stream.
     * Lança EOFException se o stream acabar antes.
     */
    private byte[] lerBytes (int n) throws IOException {
        byte[] buf = new byte[n];
        int lidos = 0;
        while (lidos < n) {
            int resultado = in.read(buf, lidos, n - lidos);
            if (resultado == -1)
                throw new EOFException(
                        "Stream encerrou antes de ler " + n + " bytes");
            lidos += resultado;
        }
        return buf;
    }

    /**
     * Lê 4 bytes e reconstrói um int.
     * Lança EOFException se o stream acabar inesperadamente.
     */
    private int readInt() throws IOException {
        int b1 = in.read(), b2 = in.read(),
                b3 = in.read(), b4 = in.read();
        if ((b1 | b2 | b3 | b4) == -1)
            throw new EOFException("Fim inesperado do stream ao ler int");
        return ((b1 & 0xFF) << 24) |
                ((b2 & 0xFF) << 16) |
                ((b3 & 0xFF) << 8)  |
                (b4 & 0xFF);
    }
}