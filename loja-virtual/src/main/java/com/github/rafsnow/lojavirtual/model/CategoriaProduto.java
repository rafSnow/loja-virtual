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
@Table(name = "categoria_produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class CategoriaProduto {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria_produto")
  @SequenceGenerator(name = "seq_categoria_produto", sequenceName = "seq_categoria_produto", allocationSize = 1, initialValue = 1)
  @EqualsAndHashCode.Include
  private Long id;

  @NotBlank(message = "A descrição da categoria do produto é obrigatória")
  @Column(name = "descricao", nullable = false, length = 100)
  private String descricao;

  @NotBlank(message = "O status ativo/inativo da categoria do produto é obrigatório")
  @Column(name = "ativo", nullable = false)
  private Boolean ativo = true;
}
