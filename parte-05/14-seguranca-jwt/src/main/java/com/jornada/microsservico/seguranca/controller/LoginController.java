package com.jornada.microsservico.seguranca.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jornada.microsservico.seguranca.controller.dto.LoginDTO;
import com.jornada.microsservico.seguranca.exception.BaseException;
import com.jornada.microsservico.seguranca.security.JWTToken;
import com.jornada.microsservico.seguranca.service.LoginService;

@RestController
@RequestMapping(path = "/login")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @ResponseBody
    @PostMapping(path = "", produces = "application/json")
    public JWTToken login(@RequestBody LoginDTO dto) throws BaseException {
        return this.loginService.login(dto);
    }
}
