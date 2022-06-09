package com.mycompany.projetoa3;


import java.sql.SQLException;
import userinteface.Login;



public class ProjetoA3 {

    public static void main(String[] args) throws SQLException {
        Session.setSession(new Login());
        Session.newSession();
 
        
      
    }
}
