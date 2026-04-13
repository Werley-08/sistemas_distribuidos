package service;

import model.Departamento;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoService {

    private List<Departamento> departamentos = new ArrayList<>();

    public void adicionar(Departamento d) {
        departamentos.add(d);
    }

    public List<Departamento> listar() {
        return departamentos;
    }
}