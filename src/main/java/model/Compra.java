package model;


import java.util.ArrayList;
import java.util.List;



public class Compra {
    private int notaFiscal;
    private java.sql.Date dataCompra;
    private Cliente cliente;
    private List<Venda_Produto> produtos;
    private double valorTotal = 0.0;
    private String estado = "Processamento";

    //nova compra
    public Compra(java.sql.Date dataCompra, Cliente cliente) {
        this.dataCompra = dataCompra;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    public Compra(int notaFiscal, java.sql.Date dataCompra, Cliente cliente, List<Venda_Produto> produtos, String estado) {
        this.notaFiscal = notaFiscal;
        this.dataCompra = dataCompra;
        this.cliente = cliente;
        this.produtos = produtos;
        for (Venda_Produto produtoVendido: produtos){
            valorTotal += produtoVendido.getTotal();
        }
        this.estado = estado;
    }

    
    public void addProduto(Produto produto, int quantidade ){
        produtos.add(new Venda_Produto(produto, quantidade));
    }
    
    public void removeProduto(Produto produto){
        produtos.removeIf(x -> x.getProduto().equals(produto));
    }
    

    public int getNotaFiscal() {
        return notaFiscal;
    }

    public java.sql.Date getDataCompra() {
        return dataCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Venda_Produto> getProdutos() {
        return produtos;
    }

    public void setNotaFiscal(int notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public void setDataCompra(java.sql.Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProdutos(List<Venda_Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getEstado() {
        return estado;
    }
    
    
    
}
