package br.com.tt.snackmachine.model;

public class Estoque {
    private Produto produto;
    private Integer quantidade;

    public Estoque(Produto p, Integer q){
        this.produto = p;
        this.quantidade = q;
    }

}
