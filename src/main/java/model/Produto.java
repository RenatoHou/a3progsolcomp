package model;


public class Produto {
    private int artigo;
    private double preco;
    private int qtde_produto;
    private String descricao;
    private String categoria;

    public Produto(int artigo, double preco, int qtde_produto, String descricao, String categoria) {
        this.artigo = artigo;
        this.preco = preco;
        this.qtde_produto = qtde_produto;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public Produto(double preco, int qtde_produto, String descricao) {
        this.preco = preco;
        this.qtde_produto = qtde_produto;
        this.descricao = descricao;
    }

    public int getArtigo() {
        return artigo;
    }

    public double getPreco() {
        return preco;
    }

    public int getQtde_produto() {
        return qtde_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setArtigo(int artigo) {
        this.artigo = artigo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQtde_produto(int qtde_produto) {
        this.qtde_produto = qtde_produto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }
    
    public void diminuirQuantidade(int quantidade){
        qtde_produto -= quantidade;
    }
    
}
    
    
    
    

