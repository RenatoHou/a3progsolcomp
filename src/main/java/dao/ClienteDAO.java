package dao;

import com.mycompany.projetoa3.Connexao_SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;


public class ClienteDAO {
    private Connection connection;

    public ClienteDAO() throws SQLException {     
        connection = Connexao_SQL.getConnection();
    }
    
    public boolean insertCliente(Cliente cliente) throws SQLException{
        String sqlQuery = "INSERT INTO cliente (cpf, nome, idade) VALUES (?,?,?)";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setInt(1, cliente.getCpf());
        statment.setString(2, cliente.getNome());
        statment.setInt(3, cliente.getIdade());
        int rowsInserted = statment.executeUpdate();      
        return (rowsInserted > 0);
    }
    
}
