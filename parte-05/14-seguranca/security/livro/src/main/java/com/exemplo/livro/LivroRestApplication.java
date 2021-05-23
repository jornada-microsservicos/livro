package com.exemplo.livro;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

/**
 *
 */
@ApplicationPath("/data")
@LoginConfig(authMethod = "BASIC", realmName = "basic-jaspi")
@DeclareRoles({"gerente,cliente"})
public class LivroRestApplication extends Application {
}