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
    
    //insere cliente ou funcionario no banco de dados
    private boolean insertCliente(Cliente cliente, boolean admin) throws SQLException{
        String sqlQuery = "INSERT INTO cliente (cpf, nome, nascimento, email, senha, admin) VALUES (?,?,?,?,?,?)";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, cliente.getCpf());
        statment.setString(2, cliente.getNome());
        statment.setInt(3, cliente.getIdade());
        statment.setString(4, cliente.getEmail());
        statment.setString(5, cliente.getSenha());
        statment.setBoolean(6, admin);
        int rowsInserted = statment.executeUpdate();      
        return (rowsInserted > 0);
    }
    public boolean insertCliente(Cliente cliente) throws SQLException{
        return insertCliente(cliente, false);
    }    
    public boolean insertFuncionario(Cliente cliente) throws SQLException{
        return insertCliente(cliente, true);
    }
    
    //encontra cliente por cpf (chave primaria)
    public Cliente findClienteByCpf(String cpf) throws SQLException{
        String sqlQuery = "SELECT cpf, nome, nascimento, email, senha, isadmin, issuperadmin FROM cliente where cpf = ? AND admin = FALSE";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, cpf);
        ResultSet result = statment.executeQuery();
        if (result.next()){
            return new Cliente(result.getString(1), result.getString(2), Year.now().getValue() - result.getInt(3), result.getString(4), result.getString(5), result.getBoolean(6), result.getBoolean(7));
        }else{
            return null;
        }
    }
    
    //encontra todos os clientes com certo nome
    public List<Cliente> findClienteByName(String nome) throws SQLException{
        String sqlQuery = "SELECT cpf, nome, nascimento, email, senha FROM cliente where nome = ? AND admin = FALSE";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, nome);
        ResultSet result = statment.executeQuery();
        List<Cliente> listaClientes = new ArrayList<>();
        while (result.next()){
            listaClientes.add( new Cliente(result.getString(1), result.getString(2), Year.now().getValue() -  result.getInt(3), result.getString(4), result.getString(5)));
        }
        return listaClientes;
    }
    
    //encontra cliente por email - Login
    public Cliente findClienteByEmail(String email) throws SQLException{
        String sqlQuery = "SELECT cpf, nome, nascimento, email, senha, isadmin, issuperadmin FROM cliente where email = ?";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, email);
        ResultSet result = statment.executeQuery();
        if (result.next()){
            return new Cliente(result.getString(1), result.getString(2), Year.now().getValue() - result.getInt(3), result.getString(4), result.getString(5), result.getBoolean(6), result.getBoolean(7));
        }else{
            return null;
        }
    }
    
    
    //lista todos os clientes
    public List<Cliente> findAllCliente() throws SQLException{
        String sqlQuery = "SELECT cpf, nome, nascimento, email, senha FROM cliente WHERE isadmin = FALSE";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        ResultSet result = statment.executeQuery();
        List<Cliente> listaClientes = new ArrayList<>();
        while (result.next()){
            listaClientes.add( new Cliente(result.getString(1), result.getString(2), Year.now().getValue() -  result.getInt(3), result.getString(4), result.getString(5)));
        }
        return listaClientes;
    }
    //encontra todos os funcionarios 
    public List<Cliente> findAllFuncionario() throws SQLException{
        String sqlQuery = "SELECT cpf, nome, nascimento, email, senha FROM cliente WHERE isadmin = TRUE AND issuperadmin = FALSE";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        ResultSet result = statment.executeQuery();
        List<Cliente> listaClientes = new ArrayList<>();
        while (result.next()){
            listaClientes.add( new Cliente(result.getString(1), result.getString(2), Year.now().getValue() -  result.getInt(3), result.getString(4), result.getString(5)));
        }
        return listaClientes;
    }
    
    //remove cliente do db
    public boolean deleteCliente(String cpf) throws SQLException{
        String sqlQuery = "DELETE FROM cliente WHERE (cpf = ?);";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, cpf);
        int rowsRemoved = statment.executeUpdate();      
        return (rowsRemoved > 0);
    }
    
    //atualiza cliente no db
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
