package com.jornada.microsservico.seguranca.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.jornada.microsservico.seguranca.domain.Usuario;

@Repository
public class UsuarioRepository {

    public Usuario procurarPorLoginESenha(String login, String senha) {
        var usuario = procurarPorLogin(login);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }

    public Usuario procurarPorLogin(String login) {
        List<Usuario> usuarios = this.buscarTodos().stream().filter(usuario ->
                usuario.getLogin().equals(login)).collect(Collectors.toList());
        if (usuarios != null && !usuarios.isEmpty()) {
            return usuarios.get(0);
        }
        return null;
    }

    public List<Usuario> buscarTodos() {
        return Arrays.asList(
                new Usuario(1l, "Admin", "admin", "admin@jornadas.io", "senha"),
                new Usuario(2l, "Cliente", "usuario", "cliente@jornadas.io", "senha"));
    }

    public Usuario procuparPorId(Long id) {
        return this.buscarTodos().stream().filter(usuario -> usuario.getId().equals(id)).collect(Collectors.toList())
                .get(0);
    }

}
