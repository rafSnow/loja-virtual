package com.github.rafsnow.lojavirtual.enums;

public enum StatusContaReceber {

  COBRANCA("Pagar"),
  VENCIDA("Vencida"),
  CANCELADA("Cancelada"),
  ABERTA("Aberta"),
  QUITADA("Quitada");

  private String descricao;

  private StatusContaReceber(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

  public String toString() {
    return this.descricao;
  }

}
