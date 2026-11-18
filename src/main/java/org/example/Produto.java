package org.example;

public abstract class Produto {

    private String descricao;

    public Produto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public abstract String getDetalhes();

    public abstract float getPreco();

    public abstract int getQuantidadeItens();
}
