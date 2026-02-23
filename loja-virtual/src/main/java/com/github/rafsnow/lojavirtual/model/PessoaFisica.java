package com.github.rafsnow.lojavirtual.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisica extends Pessoa {

  @NotBlank(message = "O campo CPF é obrigatório")
  @Column(name = "cpf", nullable = false, unique = true)
  private String cpf;

  @NotNull(message = "O campo Data de Nascimento é obrigatório")
  @Column(name = "data_nascimento", nullable = false)
  private LocalDate dataNascimento;
}
