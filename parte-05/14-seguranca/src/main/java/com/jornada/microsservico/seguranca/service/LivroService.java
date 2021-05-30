package com.jornada.microsservico.seguranca.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jornada.microsservico.seguranca.domain.Livro;

@Service
public class LivroService {
    private Map<Integer, Livro> livraria = new HashMap<>();

    public void adiciona(Livro livro) {
        livraria.put(livro.getId(), livro);
    }

    public void remove(int id) {
        livraria.remove(id);
    }

    public void atualiza(Livro livro) {
        livraria.put(livro.getId(), livro);
    }

    public List<Livro> lista() {
        return new ArrayList<>(livraria.values());
    }

    public Livro buscaPorId(int id) {
        return livraria.get(id);
    }

}
