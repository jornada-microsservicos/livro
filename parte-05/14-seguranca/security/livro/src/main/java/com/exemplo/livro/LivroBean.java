package com.exemplo.livro;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class LivroBean {

    private HashMap<Integer, Livro> livraria;

    @PostConstruct
    public void livroBean() {
        livraria = new HashMap<Integer,Livro>();
        
        Livro l1 = new Livro();
        l1.setId(1);
        l1.setNome("Livro 1");
        l1.setAutor("Autor 1");

        Livro l2 = new Livro();
        l2.setId(2);
        l2.setNome("Livro 2");
        l2.setAutor("Autor 2");
        
        livraria.put(l1.getId(), l1);
        livraria.put(l2.getId(), l2);
    }

    public void add(Livro livro) {
        livraria.put(livro.getId(), livro);
    }

    public void delete(int id) {
        livraria.remove(id);
    }

    public void update(Livro livro) {
        livraria.put(livro.getId(), livro);
    }

    public Livro get(int id) {
        return livraria.get(id);
    }

    public List<Livro> getAll() {
        Collection<Livro> livros = livraria.values();
        return new ArrayList<Livro>(livros);
    }

}
