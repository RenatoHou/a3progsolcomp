
package com.mycompany.projetoa3;

import dao.ClienteDAO;
import dao.CompraDAO;
import dao.ProdutoDAO;
import java.sql.Connection;
import java.sql.SQLException;

public class ProjetoA3 {

    public static void main(String[] args) throws SQLException {
        System.out.println(new CompraDAO().findCompraByCpf(111111));
        
      
    }
}
