package model;


public class Venda_Produto {
    Produto produto;
    int notaFiscal;
    int quantidade;
    double preco_venda;
    double total;

    public Venda_Produto(Produto produto, int notaFiscal, int quantidade, double preco_venda) {
        this.produto = produto;
        this.notaFiscal = notaFiscal;
        this.quantidade = quantidade;
        this.preco_venda = preco_venda;
        this.total = quantidade*preco_venda;
    }

    
    
    
            
}
