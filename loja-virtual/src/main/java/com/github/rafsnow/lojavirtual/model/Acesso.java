package com.github.rafsnow.lojavirtual.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
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
@Table(name = "acesso")
@SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso", allocationSize = 1, initialValue = 1)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Acesso {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
  private Long id;

  @NotBlank(message = "A descrição do acesso é obrigatória")
  @Column(name = "descricao", nullable = false, length = 100)
  private String descricao;

  @NotBlank(message = "O status ativo/inativo do acesso é obrigatório")
  @Column(name = "ativo", nullable = false)
  private Boolean ativo = true;

  @CreatedBy
  @Column(name = "usuario_criacao", nullable = false, updatable = false)
  private LocalDateTime dataCriacao;

  @LastModifiedDate
  @Column(name = "data_atualizacao")
  private LocalDateTime dataAtualizacao;

  @LastModifiedBy
  @Column(name = "usuario_atualizacao")
  private String usuarioAtualizacao;

}
