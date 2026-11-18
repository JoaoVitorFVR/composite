package org.example;

public class ProdutoSimples extends Produto {

    private float preco;

    public ProdutoSimples(String descricao, float preco) {
        super(descricao);
        this.preco = preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public int getQuantidadeItens() {
        return 1;
    }

    public String getDetalhes() {
        return "Item: " + this.getDescricao() + " - preço: " + this.preco + "\n";
    }

}
