package com.github.rafsnow.lojavirtual.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.github.rafsnow.lojavirtual.enums.TipoEndereco;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "endereco")
@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco", allocationSize = 1, initialValue = 1)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
  private Long id;
  private String rua;
  private String cep;
  private String numero;
  private String complemento;
  private String bairro;
  private String cidade;
  private String uf;
  @ManyToOne(targetEntity = Pessoa.class)
  @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_endereco_pessoa"))
  private Pessoa pessoa;
  @Enumerated(EnumType.STRING)
  private TipoEndereco tipoEndereco;

}
