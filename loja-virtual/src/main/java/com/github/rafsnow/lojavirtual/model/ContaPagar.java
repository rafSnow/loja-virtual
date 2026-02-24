package com.github.rafsnow.lojavirtual.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.github.rafsnow.lojavirtual.enums.StatusContaPagar;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "conta_pagar")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class ContaPagar extends Auditoria {

  @Id
  @SequenceGenerator(name = "seq_conta_pagar", sequenceName = "seq_conta_pagar", allocationSize = 1, initialValue = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta_pagar")
  @EqualsAndHashCode.Include
  private Long id;

  private String descricao;

  @Enumerated(EnumType.STRING)
  private StatusContaPagar status;

  private LocalDate dataVencimento;
  private LocalDate dataPagamento;
  private BigDecimal valorTotal;
  private BigDecimal valorDesconto;

  @ManyToOne(targetEntity = Pessoa.class)
  @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(name = "fk_conta_pagar_pessoa", value = ConstraintMode.CONSTRAINT))
  private Pessoa pessoa;

  @ManyToOne(targetEntity = Pessoa.class)
  @JoinColumn(name = "fornecedor_id", nullable = true, foreignKey = @ForeignKey(name = "fk_conta_pagar_fornecedor", value = ConstraintMode.CONSTRAINT))
  private Pessoa fornecedor;

  @ManyToOne(targetEntity = FormaPagamento.class)
  @JoinColumn(name = "forma_pagamento_id", nullable = true, foreignKey = @ForeignKey(name = "fk_conta_pagar_forma_pagamento", value = ConstraintMode.CONSTRAINT))
  private FormaPagamento formaPagamento;

}
