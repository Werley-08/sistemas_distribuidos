import java.io.Serializable;

public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private double valor;

    public Request(int id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}