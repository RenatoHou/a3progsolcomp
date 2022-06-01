
package com.mycompany.projetoa3;

import java.sql.Connection;
import java.sql.SQLException;

public class ProjetoA3 {

    public static void main(String[] args) throws SQLException {
      Connection connection = Connexao_SQL.getConnection();
      
      connection.close();
      
    }
}
