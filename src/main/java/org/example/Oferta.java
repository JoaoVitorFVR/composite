package org.example;

public class Oferta {

    private Produto produto;

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    private Produto getProdutoOuErro() {
        if (this.produto == null) {
            throw new NullPointerException("Oferta sem produto");
        }
        return this.produto;
    }

    public String getDetalhes() {
        return this.getProdutoOuErro().getDetalhes();
    }

    public float getPrecoTotal() {
        return this.getProdutoOuErro().getPreco();
    }

    public int getQuantidadeItens() {
        return this.getProdutoOuErro().getQuantidadeItens();
    }
}
