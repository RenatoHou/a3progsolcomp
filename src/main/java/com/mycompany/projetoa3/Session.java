/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoa3;

import dao.CompraDAO;

import java.sql.SQLException;

import java.util.Calendar;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Compra;
import model.Produto;
import model.Venda_Produto;
import userinteface.HomeV2;
import userinteface.Login;

/**
 *
 * @author renat
 */
public final class Session {
    private static Login mainWindow;
    private static Cliente user;
    private static Compra carrinho;

    private Session() {
    }

    public static Cliente getUser() {
        return user;
    }

    public static List<Venda_Produto> getCarrinho() {
        return carrinho.getProdutos();
    }

    public static void setUser(Cliente user) {
        Session.user = user;
    }

    public static boolean isAdmin() {
        return user.isAdmin();
    }
    
    public static boolean isSuperAdmin() {
        return user.isSuperAdmin();
    }
    
    public static void adicionarAoCarrinho(Produto produto, int quantidade){
        carrinho.addProduto(produto, quantidade);
    }
    
    public static void atualizarCarrinho(Produto produto, int quantidade){
        carrinho.removeProduto(produto);
        if (quantidade > 0){
            carrinho.addProduto(produto, quantidade);
        }
    }
    
    public static void setSession(Login window){
        mainWindow = window;
    }
    
    public static void newSession(){
        user = null;
        carrinho = null;
        mainWindow.limparSenha();
        mainWindow.setVisible(true);
    }
    
    public static void startSession(Cliente cliente){
        user = cliente;
        carrinho = new Compra(new java.sql.Date(Calendar.getInstance().getTimeInMillis()), user);
        HomeV2 window = new HomeV2();
        window.setVisible(true);
    }
    
    public static int checarCarrinho(Produto produto){
        for (Venda_Produto produtoCarrinho: carrinho.getProdutos()){
            if (produtoCarrinho.getProduto().equals(produto)){
                return produtoCarrinho.getQuantidade();
            }
        }
        return 0;
    }
    
    public static void fecharPedido(){
        CompraDAO compraDao;
        try {
            compraDao = new CompraDAO();
            compraDao.insertCompra(carrinho);
        } catch (SQLException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
