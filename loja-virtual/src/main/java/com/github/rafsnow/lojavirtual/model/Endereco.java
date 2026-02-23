package com.github.rafsnow.lojavirtual.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.rafsnow.lojavirtual.enums.TipoEndereco;

import jakarta.persistence.Column;
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
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Endereco extends Auditoria {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
  @SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco", allocationSize = 1, initialValue = 1)
  @EqualsAndHashCode.Include
  private Long id;

  @Column(nullable = false)
  @NotBlank(message = "O campo rua é obrigatório")
  private String rua;

  @Column(nullable = false)
  @NotBlank(message = "O campo CEP é obrigatório")
  private String cep;

  @Column(nullable = false)
  @NotBlank(message = "O campo número é obrigatório")
  private String numero;

  private String complemento;

  @Column(nullable = false)
  @NotBlank(message = "O campo bairro é obrigatório")
  private String bairro;

  @Column(nullable = false)
  @NotBlank(message = "O campo cidade é obrigatório")
  private String cidade;

  @Column(nullable = false)
  @NotBlank(message = "O campo UF é obrigatório")
  private String uf;

  @JsonIgnore
  @ManyToOne(targetEntity = Pessoa.class)
  @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_endereco_pessoa"))
  private Pessoa pessoa;

  @Enumerated(EnumType.STRING)
  private TipoEndereco tipoEndereco;

}
