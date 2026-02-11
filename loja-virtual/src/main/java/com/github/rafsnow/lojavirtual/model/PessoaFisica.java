package com.github.rafsnow.lojavirtual.model;

import java.time.LocalDateTime;
import java.util.Date;

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
@Table(name = "pessoa_fisica")
@SequenceGenerator(name = "seq_pessoa_fisica", sequenceName = "seq_pessoa_fisica", allocationSize = 1, initialValue = 1)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class PessoaFisica {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa_fisica")
  private Long id;

  @NotBlank(message = "O campo CPF é obrigatório")
  @Column(name = "cpf", nullable = false, unique = true)
  private String cpf;

  @NotBlank(message = "O campo Data de Nascimento é obrigatório")
  @Column(name = "data_nascimento", nullable = false)
  private Date dataNascimento;

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
