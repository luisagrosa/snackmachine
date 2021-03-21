package br.com.tt.snackmachine.model;

public class Estoque {
    private Produto produto;
    private Integer quantidade;

    public Estoque(Produto p, Integer q){
        this.produto = p;
        this.quantidade = q;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public Produto getProduto(){
        return this.produto;
    }
}
