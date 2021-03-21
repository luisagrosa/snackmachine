package br.com.tt.snackmachine.model;

public class Produto implements Comparable<Produto>{
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

    public String getDescricaoCompleta(){
        return String.format("%d -  %s, categoria %s ,por R$%.2f", id, descricao, categoria, preco);
    }

    public int compareTo(Produto p1) throws  IllegalArgumentException{
        if(this.id == null || p1.id == null || p1 == null){
            throw new IllegalArgumentException("Não podem haver produtos com ID nulo");
        }
    return this.id.compareTo(p1.id);
    }


}


