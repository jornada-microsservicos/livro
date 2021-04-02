package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Dados de colaboradores da empresa
 */
@Schema(description = "Dados de colaboradores da empresa")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-02T12:20:48.886Z[GMT]")


public class Funcionario   {
  @JsonProperty("funcionario_id")
  private String funcionarioId = null;

  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("departamento")
  private String departamento = null;

  @JsonProperty("salario")
  private Integer salario = null;

  public Funcionario funcionarioId(String funcionarioId) {
    this.funcionarioId = funcionarioId;
    return this;
  }

  /**
   * Get funcionarioId
   * @return funcionarioId
   **/
  @Schema(description = "")
  
    public String getFuncionarioId() {
    return funcionarioId;
  }

  public void setFuncionarioId(String funcionarioId) {
    this.funcionarioId = funcionarioId;
  }

  public Funcionario nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
   **/
  @Schema(description = "")
  
    public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Funcionario departamento(String departamento) {
    this.departamento = departamento;
    return this;
  }

  /**
   * Get departamento
   * @return departamento
   **/
  @Schema(description = "")
  
    public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public Funcionario salario(Integer salario) {
    this.salario = salario;
    return this;
  }

  /**
   * Get salario
   * @return salario
   **/
  @Schema(description = "")
  
    public Integer getSalario() {
    return salario;
  }

  public void setSalario(Integer salario) {
    this.salario = salario;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Funcionario funcionario = (Funcionario) o;
    return Objects.equals(this.funcionarioId, funcionario.funcionarioId) &&
        Objects.equals(this.nome, funcionario.nome) &&
        Objects.equals(this.departamento, funcionario.departamento) &&
        Objects.equals(this.salario, funcionario.salario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(funcionarioId, nome, departamento, salario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Funcionario {\n");
    
    sb.append("    funcionarioId: ").append(toIndentedString(funcionarioId)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    departamento: ").append(toIndentedString(departamento)).append("\n");
    sb.append("    salario: ").append(toIndentedString(salario)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
