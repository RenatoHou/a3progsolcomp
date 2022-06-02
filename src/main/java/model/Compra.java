package model;

import dao.ProdutoDAO;
import dao.Venda_ProdutoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Compra {
    private int notaFiscal;
    private int dataCompra;
    private Cliente cliente;
    private List<Venda_Produto> produtos;
    private double valorTotal;

    //nova compra
    public Compra(int dataCompra, Cliente cliente) {
        this.dataCompra = dataCompra;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    public Compra(int notaFiscal, int dataCompra, Cliente cliente, List<Venda_Produto> produtos) {
        this.notaFiscal = notaFiscal;
        this.dataCompra = dataCompra;
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    
    public void addProduto(Produto produto, int quantidade ){
        produtos.add(new Venda_Produto(produto, quantidade));
    }
    
    
    

    public int getNotaFiscal() {
        return notaFiscal;
    }

    public int getDataCompra() {
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

    public void setDataCompra(int dataCompra) {
        this.dataCompra = dataCompra;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProdutos(List<Venda_Produto> produtos) {
        this.produtos = produtos;
    }
    
    
    
}
