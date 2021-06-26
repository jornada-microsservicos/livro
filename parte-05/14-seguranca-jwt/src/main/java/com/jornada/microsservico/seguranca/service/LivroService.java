package com.jornada.microsservico.seguranca.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jornada.microsservico.seguranca.domain.Livro;
import com.jornada.microsservico.seguranca.exception.BaseException;
import com.jornada.microsservico.seguranca.exception.NotFoundException;

@Service
public class LivroService {
    private Map<Integer, Livro> livraria = new HashMap<>();

    public Livro adicionar(Livro livro) {
        livraria.put(livro.getId(), livro);
        return livro;
    }

    public void remover(int id) {
        livraria.remove(id);
    }

    public void atualizar(Livro livro) {
        livraria.put(livro.getId(), livro);
    }

    public List<Livro> listar() {
        return new ArrayList<>(livraria.values());
    }

    public Livro buscarPorId(int id) throws BaseException {
        Livro livro = livraria.get(id);
        if (livro == null) {
            throw new NotFoundException("Livro não encontrado com o id: " + id);
        }
        return livro;
    }

}
