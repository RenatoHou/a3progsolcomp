package dao;

import com.mycompany.projetoa3.Connexao_SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
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
        String sqlQuery = "INSERT INTO cliente (cpf, nome, nascimento, email, senha) VALUES (?,?,?,?,?)";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, cliente.getCpf());
        statment.setString(2, cliente.getNome());
        statment.setInt(3, cliente.getIdade());
        statment.setString(4, cliente.getEmail());
        statment.setString(5, cliente.getSenha());
        int rowsInserted = statment.executeUpdate();      
        return (rowsInserted > 0);
    }
    
    //encontra cliente por cpf (chave primaria)
    public Cliente findClienteByCpf(String cpf) throws SQLException{
        String sqlQuery = "SELECT cpf, nome, nascimento, email, senha, admin FROM cliente where cpf = ?";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, cpf);
        ResultSet result = statment.executeQuery();
        if (result.next()){
            return new Cliente(result.getString(1), result.getString(2), Year.now().getValue() - result.getInt(3), result.getString(4), result.getString(5), result.getBoolean(6));
        }else{
            return null;
        }
    }
    
    //encontra todos os clientes com certo nome
    public List<Cliente> findClienteByName(String nome) throws SQLException{
        String sqlQuery = "SELECT cpf, nome, nascimento, email, senha FROM cliente where nome = ?";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, nome);
        ResultSet result = statment.executeQuery();
        List<Cliente> listaClientes = new ArrayList<>();
        while (result.next()){
            listaClientes.add( new Cliente(result.getString(1), result.getString(2), Year.now().getValue() -  result.getInt(3), result.getString(4), result.getString(5), result.getBoolean(6)));
        }
        return listaClientes;
    }
    
    public Cliente findClienteByEmail(String email) throws SQLException{
        String sqlQuery = "SELECT cpf, nome, nascimento, email, senha, admin FROM cliente where email = ?";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, email);
        ResultSet result = statment.executeQuery();
        if (result.next()){
            return new Cliente(result.getString(1), result.getString(2), Year.now().getValue() - result.getInt(3), result.getString(4), result.getString(5), result.getBoolean(6));
        }else{
            return null;
        }
    }
    
    public List<Cliente> findAllCliente() throws SQLException{
        String sqlQuery = "SELECT cpf, nome, nascimento, email, senha FROM cliente";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        ResultSet result = statment.executeQuery();
        List<Cliente> listaClientes = new ArrayList<>();
        while (result.next()){
            listaClientes.add( new Cliente(result.getString(1), result.getString(2), Year.now().getValue() -  result.getInt(3), result.getString(4), result.getString(5), result.getBoolean(6)));
        }
        return listaClientes;
    }
    
    public boolean deleteCliente(String cpf) throws SQLException{
        String sqlQuery = "DELETE FROM cliente WHERE (cpf = ?);";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, cpf);
        int rowsRemoved = statment.executeUpdate();      
        return (rowsRemoved > 0);
    }
    
    public boolean updateCliente(Cliente cliente) throws SQLException{
        String sqlQuery = "UPDATE cliente SET nome = ?, nascimento = ?, email = ? WHERE (cpf = ?);";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, cliente.getNome());
        statment.setInt(2, Year.now().getValue() - cliente.getIdade());
        statment.setString(3, cliente.getEmail());
        statment.setString(4, cliente.getCpf());
        int rowsAffected = statment.executeUpdate();      
        return (rowsAffected > 0);
    }
    
    public void close() throws SQLException{
        connection.close();
    }
    
}
