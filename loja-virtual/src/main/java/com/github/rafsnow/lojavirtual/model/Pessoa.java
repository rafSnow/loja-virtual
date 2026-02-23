package com.github.rafsnow.lojavirtual.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Pessoa extends Auditoria {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
  @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1, initialValue = 1)
  @EqualsAndHashCode.Include
  private Long id;

  @Size(min = 3, message = "O nome da pessoa deve conter no mínimo 3 caracteres")
  @NotBlank(message = "O nome da pessoa é obrigatório")
  @Column(nullable = false)
  private String nome;

  @Email(message = "O email da pessoa deve ser válido")
  @NotBlank(message = "O email da pessoa é obrigatório")
  @Column(nullable = false, unique = true)
  private String email;

  @NotBlank(message = "O telefone da pessoa é obrigatório")
  @Column(name = "telefone", length = 15, nullable = false)
  private String telefone;

  @NotBlank(message = "O tipo da pessoa é obrigatório")
  @Column(nullable = false)
  private String tipoPessoa;

  @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Endereco> enderecos = new ArrayList<>();

  @ManyToOne(targetEntity = Pessoa.class)
  @JoinColumn(name = "empresa_id", nullable = true, foreignKey = @ForeignKey(name = "fk_pessoa_empresa", value = ConstraintMode.CONSTRAINT))
  private Pessoa empresa;

  @NotBlank(message = "O status ativo/inativo da pessoa é obrigatório")
  @Column(name = "ativo", nullable = false)
  private Boolean ativo = true;

}
