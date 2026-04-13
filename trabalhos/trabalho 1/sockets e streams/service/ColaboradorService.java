package service;

import model.Colaborador;

import java.util.ArrayList;
import java.util.List;

public class ColaboradorService {

    private List<Colaborador> lista = new ArrayList<>();

    public void adicionar(Colaborador c) {
        lista.add(c);
    }

    public List<Colaborador> listar() {
        return lista;
    }
}