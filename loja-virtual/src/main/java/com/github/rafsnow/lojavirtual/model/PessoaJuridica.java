package com.github.rafsnow.lojavirtual.model;

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
@Table(name = "pessoa_juridica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class PessoaJuridica extends Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa_juridica")
  @SequenceGenerator(name = "seq_pessoa_juridica", sequenceName = "seq_pessoa_juridica", allocationSize = 1, initialValue = 1)
  @EqualsAndHashCode.Include
  private Long id;

  @NotBlank(message = "O campo CNPJ é obrigatório")
  @Column(name = "cnpj", nullable = false, unique = true)
  private String cnpj;

  @Column(name = "inscricao_estadual")
  private String inscricaoEstadual;

  @Column(name = "inscricao_municipal")
  private String inscricaoMunicipal;

  @NotBlank(message = "O campo Nome Fantasia é obrigatório")
  @Column(name = "nome_fantasia", nullable = false)
  private String nomeFantasia;

  @Column(name = "razao_social")
  private String razaoSocial;

  @Column(name = "categoria")
  private String categoria;
}
