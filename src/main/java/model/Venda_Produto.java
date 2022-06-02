package model;


public class Venda_Produto {
    private Produto produto;
    private int notaFiscal;
    private int quantidade;
    private double preco_venda;
    private double total;

    public Venda_Produto(Produto produto, int notaFiscal, int quantidade, double preco_venda) {
        this.produto = produto;
        this.notaFiscal = notaFiscal;
        this.quantidade = quantidade;
        this.preco_venda = preco_venda;
        this.total = quantidade*preco_venda;
    }

    public Venda_Produto(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco_venda = produto.getPreco();
        this.total = quantidade*preco_venda;
    }
    
    

    public Produto getProduto() {
        return produto;
    }

    public int getNotaFiscal() {
        return notaFiscal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public double getTotal() {
        return total;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setNotaFiscal(int notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
    
    
            
}
