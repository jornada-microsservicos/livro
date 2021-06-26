package com.jornada.microsservico.seguranca.service;

import org.springframework.stereotype.Service;

import com.jornada.microsservico.seguranca.controller.dto.LoginDTO;
import com.jornada.microsservico.seguranca.domain.Usuario;
import com.jornada.microsservico.seguranca.exception.BaseException;
import com.jornada.microsservico.seguranca.exception.NotFoundException;
import com.jornada.microsservico.seguranca.security.JWTToken;
import com.jornada.microsservico.seguranca.security.JWTUtil;

@Service
public class LoginService {

    private UsuarioService usuarioService;

    public LoginService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public JWTToken login(LoginDTO dto) throws BaseException {
        if (dto.getLogin().equals("jornada.colaborativa") && dto.getSenha().equals("123456")) {
            Usuario usuario = this.usuarioService.buscarUsuarioPorLoginESenha(dto.getLogin(), dto.getSenha());
            return new JWTToken(JWTUtil.gerarToken(usuario));
        }
        throw new NotFoundException("Login ou senha não encontrado");
    }
}
