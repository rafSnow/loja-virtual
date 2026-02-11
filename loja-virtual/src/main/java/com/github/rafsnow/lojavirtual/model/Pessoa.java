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
@Table(name = "pessoa")
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1, initialValue = 1)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
  private Long id;

  @NotBlank(message = "O nome da pessoa é obrigatório")
  @Column(name = "nome", nullable = false, length = 100)
  private String nome;

  @NotBlank(message = "O email da pessoa é obrigatório")
  @Column(name = "email", nullable = false, length = 100, unique = true)
  private String email;

  @Column(name = "telefone", length = 15)
  private String telefone;

  @NotBlank(message = "O status ativo/inativo da pessoa é obrigatório")
  @Column(name = "ativo", nullable = false)
  private Boolean ativo = true;

  @CreatedDate
  @NotBlank(message = "A data de criação é obrigatória")
  @Column(name = "data_criacao", nullable = false, updatable = false)
  private LocalDateTime dataCriacao;

  @LastModifiedDate
  @Column(name = "data_atualizacao")
  private LocalDateTime dataAtualizacao;

  @LastModifiedBy
  @Column(name = "usuario_atualizacao")
  private String usuarioAtualizacao;

}
