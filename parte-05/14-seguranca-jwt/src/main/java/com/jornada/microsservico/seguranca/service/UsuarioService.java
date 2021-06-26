package com.jornada.microsservico.seguranca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jornada.microsservico.seguranca.domain.Usuario;
import com.jornada.microsservico.seguranca.repository.UsuarioRepository;
import com.jornada.microsservico.seguranca.security.JWTUtil;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarUsuarioPorLoginESenha(String login, String senha) {
        return usuarioRepository.procurarPorLoginESenha(login, senha);
    }

    public Usuario buscarPorToken(String token) {
        return usuarioRepository.procuparPorId(JWTUtil.recuperaIdUsuario(token));
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.buscarTodos();
    }

}
