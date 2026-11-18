package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfertaTest {

    Combo comboFamilia;

    @BeforeEach
    void setUp() {
        Combo lanches = new Combo("Lanches");
        lanches.addProduto(new ProdutoSimples("Hamburguer", 20.0f));
        lanches.addProduto(new ProdutoSimples("Batata", 8.0f));

        Combo bebidas = new Combo("Bebidas");
        bebidas.addProduto(new ProdutoSimples("Suco", 6.0f));
        bebidas.addProduto(new ProdutoSimples("Refrigerante", 7.0f));

        comboFamilia = new Combo("Combo Família");
        comboFamilia.addProduto(lanches);
        comboFamilia.addProduto(bebidas);
        comboFamilia.addProduto(new ProdutoSimples("Sobremesa", 12.5f));
    }

    @Test
    void deveRetornarDetalhesOferta() {
        Oferta oferta = new Oferta();
        oferta.setProduto(comboFamilia);

        assertEquals("Combo: Combo Família\n" +
                "Combo: Lanches\n" +
                "Item: Hamburguer - preço: 20.0\n" +
                "Item: Batata - preço: 8.0\n" +
                "Combo: Bebidas\n" +
                "Item: Suco - preço: 6.0\n" +
                "Item: Refrigerante - preço: 7.0\n" +
                "Item: Sobremesa - preço: 12.5\n", oferta.getDetalhes());
    }

    @Test
    void deveRetornarPrecoTotalOferta() {
        Oferta oferta = new Oferta();
        oferta.setProduto(comboFamilia);

        assertEquals(53.5f, oferta.getPrecoTotal(), 0.01f);
    }

    @Test
    void deveRetornarQuantidadeItensOferta() {
        Oferta oferta = new Oferta();
        oferta.setProduto(comboFamilia);

        assertEquals(5, oferta.getQuantidadeItens());
    }

    @Test
    void deveTratarProdutoSimplesComoOferta() {
        Oferta oferta = new Oferta();
        oferta.setProduto(new ProdutoSimples("Suco", 6.0f));

        assertEquals("Item: Suco - preço: 6.0\n", oferta.getDetalhes());
        assertEquals(6.0f, oferta.getPrecoTotal(), 0.01f);
        assertEquals(1, oferta.getQuantidadeItens());
    }

    @Test
    void deveTratarComboVazio() {
        Oferta oferta = new Oferta();
        oferta.setProduto(new Combo("Combo vazio"));

        assertEquals("Combo: Combo vazio\n", oferta.getDetalhes());
        assertEquals(0.0f, oferta.getPrecoTotal(), 0.01f);
        assertEquals(0, oferta.getQuantidadeItens());
    }

    @Test
    void deveRecalcularPrecoQuandoAlteraUmItem() {
        ProdutoSimples suco = new ProdutoSimples("Suco", 6.0f);
        Combo combo = new Combo("Combo");
        combo.addProduto(suco);
        combo.addProduto(new ProdutoSimples("Batata", 8.0f));

        suco.setPreco(10.0f);

        assertEquals(18.0f, combo.getPreco(), 0.01f);
    }

    @Test
    void deveRetornarExcecaoOfertaSemProduto() {
        try {
            Oferta oferta = new Oferta();
            oferta.getDetalhes();
            fail();
        }
        catch (NullPointerException e) {
            assertEquals("Oferta sem produto", e.getMessage());
        }
    }

}
