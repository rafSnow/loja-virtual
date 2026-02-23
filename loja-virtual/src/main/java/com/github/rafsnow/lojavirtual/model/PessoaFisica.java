package com.github.rafsnow.lojavirtual.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoa_fisica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class PessoaFisica extends Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa_fisica")
  @SequenceGenerator(name = "seq_pessoa_fisica", sequenceName = "seq_pessoa_fisica", allocationSize = 1, initialValue = 1)
  @EqualsAndHashCode.Include
  private Long id;

  @NotBlank(message = "O campo CPF é obrigatório")
  @Column(name = "cpf", nullable = false, unique = true)
  private String cpf;

  @NotBlank(message = "O campo Data de Nascimento é obrigatório")
  @Column(name = "data_nascimento", nullable = false)
  private Date dataNascimento;
}
