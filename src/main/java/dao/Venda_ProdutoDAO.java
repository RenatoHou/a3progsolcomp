
package dao;

import com.mycompany.projetoa3.Connexao_SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.StatementEvent;
import model.Produto;
import model.Venda_Produto;


public class Venda_ProdutoDAO {
    private Connection connection;
    
    public Venda_ProdutoDAO() throws SQLException {
        connection = Connexao_SQL.getConnection();
    }
    
    //retorna todas as Venda_Produto de um nf
    public List<Venda_Produto> findVenda_Produto(int nf) throws SQLException{
        String sqlQuery = "SELECT produto.*, venda_produto.* "
                + "        FROM venda_produto JOIN produto ON produto.artigo = venda_produto.cod_produto"
                + "        WHERE venda_produto.nf = ?;"; 
        
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setInt(1, nf);
        ResultSet result = statment.executeQuery();
        List<Venda_Produto> vendas = new ArrayList<>();
        while (result.next()){
            vendas.add(new Venda_Produto(new Produto(result.getInt(1), result.getDouble(2), result.getInt(3), result.getString(4), result.getString(5)), //produto
                       result.getInt(6), //notaFiscal
                       result.getInt(8), //quantidade
                       result.getDouble(9))); //valorDoItem
        }
        connection.close();
        return vendas;
    }
    
    public boolean insertVenda_Produto(List<Venda_Produto> produtosVendidos, long nf) throws SQLException{
        for (Venda_Produto produtoVendido: produtosVendidos){
            //insere na tabela Venda_Produto
            String sql = "INSERT INTO venda_produto VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, nf); //notaFiscal
            statement.setInt(2, produtoVendido.getProduto().getArtigo()); //codProduto
            statement.setInt(3, produtoVendido.getQuantidade()); //qtdeVendida
            statement.setDouble(4, produtoVendido.getPreco_venda()); //precoVenda
            if (statement.executeUpdate() == 0)
                return false;
            
            //diminuir estoque
            produtoVendido.getProduto().diminuirQuantidade(produtoVendido.getQuantidade());
            ProdutoDAO produtoDAO = new ProdutoDAO();           
            produtoDAO.updateProduto(produtoVendido.getProduto());
            
        }
        return true;
    }
    
    public void close() throws SQLException{
        connection.close();
    }
    
}
