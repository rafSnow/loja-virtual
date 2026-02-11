package com.github.rafsnow.lojavirtual.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pessoa_juridica")
@SequenceGenerator(name = "seq_pessoa_juridica", sequenceName = "seq_pessoa_juridica", allocationSize = 1, initialValue = 1)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class PessoaJuridica {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa_juridica")
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

  @CreatedDate
  @Column(name = "data_criacao", nullable = false, updatable = false)
  private LocalDateTime dataCriacao;

  @LastModifiedDate
  @Column(name = "data_atualizacao")
  private LocalDateTime dataAtualizacao;

  @LastModifiedBy
  @Column(name = "usuario_atualizacao")
  private String usuarioAtualizacao;
}
