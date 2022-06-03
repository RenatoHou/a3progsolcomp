
package com.mycompany.projetoa3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexao_SQL {
    static String url_bd = "jdbc:mysql://localhost:3306/project_java";
    static String username = "renato";
    static String password = "pass";
    
    public static Connection getConnection () throws SQLException{
        Connection connection = null;
        
        connection = DriverManager.getConnection(url_bd, username, password);
        System.out.println("Conexão deu tudo certo :) ");
        return connection;
               
    }
    
}
