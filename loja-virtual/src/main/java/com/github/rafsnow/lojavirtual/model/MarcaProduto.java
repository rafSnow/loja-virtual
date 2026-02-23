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
@Table(name = "marca_produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class MarcaProduto extends Auditoria {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca_produto")
  @SequenceGenerator(name = "seq_marca_produto", sequenceName = "seq_marca_produto", allocationSize = 1, initialValue = 1)
  @EqualsAndHashCode.Include
  private Long id;

  @NotBlank(message = "A descrição da marca do produto é obrigatória")
  @Column(name = "descricao", nullable = false, length = 100)
  private String descricao;

  @NotBlank(message = "O status ativo/inativo da marca do produto é obrigatório")
  @Column(name = "ativo", nullable = false)
  private Boolean ativo = true;

}
