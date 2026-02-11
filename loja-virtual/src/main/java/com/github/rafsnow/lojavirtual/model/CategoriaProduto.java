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
@Table(name = "categoria_produto")
@SequenceGenerator(name = "seq_categoria_produto", sequenceName = "seq_categoria_produto", allocationSize = 1, initialValue = 1)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class CategoriaProduto {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria_produto")
  private Long id;

  @NotBlank(message = "A descrição da categoria do produto é obrigatória")
  @Column(name = "descricao", nullable = false, length = 100)
  private String descricao;

  @NotBlank(message = "O status ativo/inativo da categoria do produto é obrigatório")
  @Column(name = "ativo", nullable = false)
  private Boolean ativo = true;

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
