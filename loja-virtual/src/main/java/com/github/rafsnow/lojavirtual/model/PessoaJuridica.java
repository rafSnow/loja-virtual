package com.github.rafsnow.lojavirtual.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "pessoa_juridica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaJuridica extends Pessoa {

  @NotBlank(message = "O campo CNPJ é obrigatório")
  @Size(min = 14, max = 18, message = "O campo CNPJ deve conter entre 14 e 18 caracteres")
  @Column(nullable = false, unique = true, length = 18)
  private String cnpj;

  @NotBlank(message = "O campo Inscrição Estadual é obrigatório")
  @Column(nullable = false)
  private String inscricaoEstadual;

  @Column(nullable = true)
  private String inscricaoMunicipal;

  @NotBlank(message = "O campo Nome Fantasia é obrigatório")
  @Column(nullable = false)
  private String nomeFantasia;

  @NotBlank(message = "O campo Razão Social é obrigatório")
  @Column(nullable = false)
  private String razaoSocial;

  @NotBlank(message = "O campo Categoria é obrigatório")
  @Column(nullable = false)
  private String categoria;
}
