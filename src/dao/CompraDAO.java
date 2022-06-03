package dao;

import com.mycompany.projetoa3.Connexao_SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Compra;


public class CompraDAO {
    private Connection connection;
    
    public CompraDAO() throws SQLException {
        connection = Connexao_SQL.getConnection();
    }
    
    //encontrar compra por numero da NF
    public Compra findCompraByNf(int nf) throws SQLException{
        String sqlQuery = "SELECT compra.*, cliente.* FROM compra JOIN cliente ON compra.cpf_cliente = cliente.cpf WHERE compra.nf = ?;";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setInt(1, nf);
        ResultSet result = statment.executeQuery();
        if (result.next()){
            return new Compra(result.getInt(1), //nf
                              result.getInt(2), //compra 
                              new Cliente(result.getInt(4), result.getString(5), result.getInt(6)),
                              new Venda_ProdutoDAO().findVenda_Produto(nf)
                             );         
        }else{
            return null;
        }
    }
    
    //Encontrar Compra por cpf do cliente
    public List<Compra> findCompraByCpf(int cpf) throws SQLException{
        String sqlQuery = "SELECT compra.*, cliente.* FROM compra JOIN cliente ON compra.cpf_cliente = cliente.cpf WHERE cliente.cpf = ?;";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setInt(1, cpf);
        ResultSet result = statment.executeQuery();
        List<Compra> compras = new ArrayList<>();
        while (result.next()){
            compras.add(new Compra(result.getInt(1), //nf
                              result.getInt(2), //compra 
                              new Cliente(result.getInt(4), result.getString(5), result.getInt(6)),
                              new Venda_ProdutoDAO().findVenda_Produto(result.getInt(1))
                            )
            );         
        }
        return compras;
    }
    
    //Retorna todas as Compras
    public List<Compra> findAllCompra() throws SQLException{
        String sqlQuery = "SELECT compra.*, cliente.* FROM compra JOIN cliente ON compra.cpf_cliente = cliente.cpf";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        ResultSet result = statment.executeQuery();
        List<Compra> compras = new ArrayList<>();
        while (result.next()){
            compras.add(new Compra(result.getInt(1), //nf
                              result.getInt(2), //compra 
                              new Cliente(result.getInt(4), result.getString(5), result.getInt(6)),
                              new Venda_ProdutoDAO().findVenda_Produto(result.getInt(1))
                            )
            );         
        }
        return compras;
    }
    
    //insere uma compra no banco de dados
    public boolean insertCompra(Compra compra) throws SQLException{
        String sql = "INSERT INTO compra VALUES (null, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, compra.getDataCompra());
        statement.setInt(2, compra.getCliente().getCpf());
        int rowsInserted = statement.executeUpdate();    
        
        if (rowsInserted > 0){
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()){
                if (new Venda_ProdutoDAO().insertVenda_Produto(compra.getProdutos(), keys.getLong(1)))
                    return true;
            }
        }
        return false;
        
    }
    
}
