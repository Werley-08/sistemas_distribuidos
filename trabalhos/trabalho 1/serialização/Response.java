import java.io.Serializable;

public class Response implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mensagem;

    public Response(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}