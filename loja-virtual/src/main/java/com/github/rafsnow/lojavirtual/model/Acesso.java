package com.github.rafsnow.lojavirtual.model;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "acesso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Acesso extends Auditoria implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
  @SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso", allocationSize = 1, initialValue = 1)
  @EqualsAndHashCode.Include
  private Long id;

  @NotBlank(message = "A descrição do acesso é obrigatória")
  @Column(name = "descricao", nullable = false, length = 100)
  private String descricao;

  @NotNull(message = "O status ativo/inativo do acesso é obrigatório")
  @Column(name = "ativo", nullable = false)
  private Boolean ativo = true;

  @JsonIgnore
  @Override
  public String getAuthority() {
    return this.descricao;
  }
}
