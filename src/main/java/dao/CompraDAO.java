package dao;

import com.mycompany.projetoa3.Connexao_SQL;
import dados.relatorios.DadosRelatorioCliente;
import dados.relatorios.DadosRelatorioEstado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
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
                              result.getDate(2), //compra 
                              new Cliente(result.getString(5), result.getString(6), result.getInt(7), result.getString(8), result.getString(9)),
                              new Venda_ProdutoDAO().findVenda_Produto(nf),
                              result.getString(4)
                             );         
        }else{
            return null;
        }
    }
    
    //Encontrar Compra por cpf do cliente
    public List<Compra> findCompraByCpf(String cpf) throws SQLException{
        String sqlQuery = "SELECT compra.*, cliente.* FROM compra JOIN cliente ON compra.cpf_cliente = cliente.cpf WHERE cliente.cpf = ? AND estado = ?;";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, cpf);
        ResultSet result = statment.executeQuery();
        List<Compra> compras = new ArrayList<>();
        while (result.next()){
            compras.add(new Compra(result.getInt(1), //nf
                              result.getDate(2), //compra 
                              new Cliente(result.getString(5), result.getString(6), result.getInt(7), result.getString(8), result.getString(9)),
                              new Venda_ProdutoDAO().findVenda_Produto(result.getInt(1)),
                              result.getString(4)
                            )
            );         
        }
        return compras;
    }
    public List<Compra> findCompraByCpf(String cpf, String estado) throws SQLException{
        String sqlQuery = "SELECT compra.*, cliente.* FROM compra JOIN cliente ON compra.cpf_cliente = cliente.cpf WHERE cliente.cpf = ? AND estado LIKE ?;";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, cpf);
        statment.setString(2, "%" + estado);
        ResultSet result = statment.executeQuery();
        List<Compra> compras = new ArrayList<>();
        while (result.next()){
            compras.add(new Compra(result.getInt(1), //nf
                              result.getDate(2), //compra 
                              new Cliente(result.getString(5), result.getString(6), result.getInt(7), result.getString(8), result.getString(9)),
                              new Venda_ProdutoDAO().findVenda_Produto(result.getInt(1)),
                              result.getString(4)
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
                              result.getDate(2), //compra 
                              new Cliente(result.getString(5), result.getString(6), result.getInt(7), result.getString(8), result.getString(9)),
                              new Venda_ProdutoDAO().findVenda_Produto(result.getInt(1)),
                              result.getString(4)
                            )
            );         
        }
        return compras;
    }
    //Retorna todas as compras em certo estado
    public List<Compra> findAllCompra(String estado) throws SQLException{
        String sqlQuery = "SELECT compra.*, cliente.* FROM compra JOIN cliente ON compra.cpf_cliente = cliente.cpf WHERE estado = ?";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, estado);
        ResultSet result = statment.executeQuery();
        List<Compra> compras = new ArrayList<>();
        while (result.next()){
            compras.add(new Compra(result.getInt(1), //nf
                              result.getDate(2), //compra 
                              new Cliente(result.getString(5), result.getString(6), result.getInt(7), result.getString(8), result.getString(9)),
                              new Venda_ProdutoDAO().findVenda_Produto(result.getInt(1)),
                              result.getString(4)
                            )
            );         
        }
        return compras;
    }
    //Retorna todas as compras nao canceladas
    public List<Compra> findAllNaoCancelada() throws SQLException{
        String sqlQuery = "SELECT compra.*, cliente.* FROM compra JOIN cliente ON compra.cpf_cliente = cliente.cpf WHERE estado  <> 'Cancelada'";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        ResultSet result = statment.executeQuery();
        List<Compra> compras = new ArrayList<>();
        while (result.next()){
            compras.add(new Compra(result.getInt(1), //nf
                              result.getDate(2), //compra 
                              new Cliente(result.getString(5), result.getString(6), result.getInt(7), result.getString(8), result.getString(9)),
                              new Venda_ProdutoDAO().findVenda_Produto(result.getInt(1)),
                              result.getString(4)
                            )
            );         
        }
        return compras;
    }
    
    /*
        Funcoes para relatorios

    */
    //retorna soma das compras agrupada por cliente
    public List<DadosRelatorioCliente> findComprasGroupByCliente(String estado) throws SQLException{
        String sqlQuery = "SELECT sum(qtde_vendida * preco_venda) as total, cliente.cpf, cliente.nome, cliente.nascimento ,cliente.email "
                + "FROM venda_produto JOIN compra on compra.nf = venda_produto.nf join cliente on cliente.cpf = compra.cpf_cliente "
                + "WHERE compra.estado LIKE ?  GROUP BY cliente.nome ORDER BY total DESC";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, "%" + estado);
        ResultSet result = statment.executeQuery();
        List<DadosRelatorioCliente> compras = new ArrayList<>();
        while (result.next()){
            compras.add(new DadosRelatorioCliente(result.getDouble(1), new Cliente(result.getString(2), result.getString(3), Year.now().getValue() - result.getInt(4), result.getString(5) )));   
        }
        return compras;
    }
    public List<DadosRelatorioCliente> findComprasGroupByClienteNaoCancelada() throws SQLException{
        String sqlQuery = "SELECT sum(qtde_vendida * preco_venda) as total, cliente.cpf, cliente.nome, cliente.nascimento ,cliente.email "
                + " FROM venda_produto JOIN compra on compra.nf = venda_produto.nf join cliente on cliente.cpf = compra.cpf_cliente"
                + " WHERE compra.estado <> 'Cancelada'  GROUP BY cliente.nome ORDER BY total DESC";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        ResultSet result = statment.executeQuery();
        List<DadosRelatorioCliente> compras = new ArrayList<>();
        while (result.next()){
            compras.add(new DadosRelatorioCliente(result.getDouble(1), new Cliente(result.getString(2), result.getString(3), Year.now().getValue() - result.getInt(4), result.getString(5) )));   
        }
        return compras;
    }
    //retorna compras agrupadas por estado
    public List<DadosRelatorioEstado> findComprasByEstado() throws SQLException{
        String sqlQuery = "SELECT count(compra.estado), compra.estado, sum(qtde_vendida * preco_venda) as total " 
                        + " FROM venda_produto JOIN compra on compra.nf = venda_produto.nf "
                        + " WHERE compra.estado LIKE '%'  GROUP BY compra.estado  ORDER BY total DESC ";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        ResultSet result = statment.executeQuery();
        List<DadosRelatorioEstado> estado = new ArrayList<>();
        while (result.next()){
            estado.add(new DadosRelatorioEstado(result.getString(2), result.getInt(1), result.getDouble(3)  ));   
        }
        return estado;
    }
    
    
    
    //insere uma compra no banco de dados
    public int insertCompra(Compra compra) throws SQLException{
        String sql = "INSERT INTO compra (data_compra, cpf_cliente) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setDate(1, compra.getDataCompra());
        statement.setString(2, compra.getCliente().getCpf());
        int rowsInserted = statement.executeUpdate();    
        
        if (rowsInserted > 0){
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()){
                if (new Venda_ProdutoDAO().insertVenda_Produto(compra.getProdutos(), keys.getLong(1)))
                    return (int)keys.getLong(1);
            }
        }
        return 0;
        
    }
    
    
    //altera estado da compra
    public boolean updateCompraEstado(int nf, String estado) throws SQLException{
        String sqlQuery = "UPDATE compra SET estado = ? WHERE (nf = ?);";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, estado);
        statment.setInt(2, nf);
        int rowsAffected = statment.executeUpdate();      
        return (rowsAffected > 0);
    }
    
    public void close() throws SQLException{
        connection.close();
    }
}
