package dao;

import com.mycompany.projetoa3.Connexao_SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;


public class ClienteDAO {
    private Connection connection;

    public ClienteDAO() throws SQLException {     
        connection = Connexao_SQL.getConnection();
    }
    
    //insere cliente no banco de dados
    public boolean insertCliente(Cliente cliente) throws SQLException{
        String sqlQuery = "INSERT INTO cliente (cpf, nome, idade) VALUES (?,?,?)";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setInt(1, cliente.getCpf());
        statment.setString(2, cliente.getNome());
        statment.setInt(3, cliente.getIdade());
        int rowsInserted = statment.executeUpdate();      
        return (rowsInserted > 0);
    }
    
    //encontra cliente por cpf (chave primaria)
    public Cliente findCliente(int cpf) throws SQLException{
        String sqlQuery = "SELECT cpf, nome, idade FROM cliente where cpf = ?";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setInt(1, cpf);
        ResultSet result = statment.executeQuery();
        if (result.next()){
            return new Cliente(result.getInt(1), result.getString(2), result.getInt(3));
        }else{
            return null;
        }
    }
    
    //encontra todos os clientes com certo nome
    public List<Cliente> findClienteByName(String nome) throws SQLException{
        String sqlQuery = "SELECT cpf, nome, idade FROM cliente where nome = ?";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, nome);
        ResultSet result = statment.executeQuery();
        List<Cliente> listaClientes = new ArrayList<>();
        while (result.next()){
            listaClientes.add( new Cliente(result.getInt(1), result.getString(2), result.getInt(3)));
        }
        return listaClientes;
    }
    
}
