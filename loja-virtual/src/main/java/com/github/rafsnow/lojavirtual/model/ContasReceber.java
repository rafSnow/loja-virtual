package com.github.rafsnow.lojavirtual.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.github.rafsnow.lojavirtual.enums.StatusContaReceber;

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
@Table(name = "conta_receber")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class ContasReceber extends Auditoria {

  @Id
  @SequenceGenerator(name = "seq_conta_receber", sequenceName = "seq_conta_receber", allocationSize = 1, initialValue = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta_receber")
  @EqualsAndHashCode.Include
  private Long id;

  private String descricao;

  @Enumerated(EnumType.STRING)
  private StatusContaReceber status;

  private LocalDate dataVencimento;
  private LocalDate dataPagamento;

  private BigDecimal valorTotal;
  private BigDecimal valorDesconto;

  @ManyToOne(targetEntity = Pessoa.class)
  @JoinColumn(name = "pessoa_id", nullable = true, foreignKey = @ForeignKey(name = "fk_conta_receber_pessoa", value = ConstraintMode.CONSTRAINT))
  private Pessoa pessoa;

}
