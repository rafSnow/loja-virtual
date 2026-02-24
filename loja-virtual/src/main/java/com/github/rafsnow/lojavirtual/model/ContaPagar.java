package com.github.rafsnow.lojavirtual.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.github.rafsnow.lojavirtual.enums.StatusContaPagar;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

  private Long id;

  private String descricao;

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
