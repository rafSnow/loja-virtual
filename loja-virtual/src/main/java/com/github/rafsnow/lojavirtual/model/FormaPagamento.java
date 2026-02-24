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
@Table(name = "forma_pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class FormaPagamento extends Auditoria {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_forma_pagamento")
  @SequenceGenerator(name = "seq_forma_pagamento", sequenceName = "seq_forma_pagamento", allocationSize = 1, initialValue = 1)
  @EqualsAndHashCode.Include
  private Long id;

  @NotBlank(message = "A descrição da forma de pagamento é obrigatória")
  @Column(name = "descricao", nullable = false, length = 100)
  private String descricao;
}
