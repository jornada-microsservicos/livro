package io.swagger.api;

import io.swagger.model.Funcionario;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-02T12:20:48.886Z[GMT]")
@RestController
public class FuncionariosApiController implements FuncionariosApi {

    private static final Logger log = LoggerFactory.getLogger(FuncionariosApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public FuncionariosApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createFuncionario(@Parameter(in = ParameterIn.DEFAULT, description = "A new `Funcionario` to be created.", required=true, schema=@Schema()) @Valid @RequestBody Funcionario body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteFuncionario(@Parameter(in = ParameterIn.PATH, description = "A unique identifier for a `Funcionario`.", required=true, schema=@Schema()) @PathVariable("funcionarioId") String funcionarioId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Funcionario> getFuncionario(@Parameter(in = ParameterIn.PATH, description = "A unique identifier for a `Funcionario`.", required=true, schema=@Schema()) @PathVariable("funcionarioId") String funcionarioId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Funcionario>(objectMapper.readValue("{\n  \"funcionario_id\" : \"11313131\",\n  \"nome\" : \"Joseph Blinker\",\n  \"departamento\" : \"Vendas\",\n  \"salario\" : 1200\n}", Funcionario.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Funcionario>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Funcionario>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Funcionario>> getFuncionarios() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Funcionario>>(objectMapper.readValue(
                        "[ {\n  \"funcionario_id\" : \"11313131\",\n  \"nome\" : \"Joseph Blinker\",\n"
                                + "  \"departamento\" : \"Vendas\",\n  \"salario\" : 1200\n}, {\n  \"funcionario_id\""
                                + " : \"11313131\",\n  \"nome\" : \"Joseph Blinker\",\n  \"departamento\" : \"Vendas\",\n"
                                + "  \"salario\" : 1200\n} ]", List.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Funcionario>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Funcionario>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> updateFuncionario(@Parameter(in = ParameterIn.PATH, description = "A unique identifier for a `Funcionario`.", required=true, schema=@Schema()) @PathVariable("funcionarioId") String funcionarioId,@Parameter(in = ParameterIn.DEFAULT, description = "Updated `Funcionario` information.", required=true, schema=@Schema()) @Valid @RequestBody Funcionario body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
