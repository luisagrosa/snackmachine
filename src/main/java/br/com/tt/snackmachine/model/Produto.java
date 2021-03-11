package br.com.tt.snackmachine.model;

public class Produto {
    private Short id;
    private Float preco;
    private String descricao;
    private CategoriaProduto categoria;

    public Produto(Short id, Float preco, String descricao, CategoriaProduto categoria){
        this.id = id;
        this.preco = preco;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public String getDescricao(){
        return descricao;
    }

    public Float getPreco(){
        return preco;
    }

    public String getCategoria(){
        return categoria.toString();
    }

    public Short getId(){
        return id;
    }



}


