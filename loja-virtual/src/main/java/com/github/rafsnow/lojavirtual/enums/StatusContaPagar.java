package com.github.rafsnow.lojavirtual.enums;

public enum StatusContaPagar {

  COBRANCA("Pagar"),
  VENCIDA("Vencida"),
  CANCELADA("Cancelada"),
  ABERTA("Aberta"),
  QUITADA("Quitada");

  private String descricao;

  private StatusContaPagar(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

  public String toString() {
    return this.descricao;
  }

}
