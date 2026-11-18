package org.example;

import java.util.ArrayList;
import java.util.List;

public class Combo extends Produto {

    private List<Produto> produtos;

    public Combo(String descricao) {
        super(descricao);
        this.produtos = new ArrayList<Produto>();
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public float getPreco() {
        float total = 0.0f;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    public int getQuantidadeItens() {
        int total = 0;
        for (Produto produto : produtos) {
            total += produto.getQuantidadeItens();
        }
        return total;
    }

    public String getDetalhes() {
        String saida = "";
        saida = "Combo: " + this.getDescricao() + "\n";
        for (Produto produto : produtos) {
            saida += produto.getDetalhes();
        }
        return saida;
    }
}
