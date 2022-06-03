
package dao;

import com.mycompany.projetoa3.Connexao_SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import model.Venda_Produto;


public class Venda_ProdutoDAO {
    private Connection connection;
    
    public Venda_ProdutoDAO() throws SQLException {
        connection = Connexao_SQL.getConnection();
    }
    
    //retorna todas as Venda_Produto de um nf
    public List<Venda_Produto> getVenda_Produto(int nf) throws SQLException{
        String sqlQuery = "SELECT produto.*, venda_produto.* "
                + "        FROM venda_produto JOIN produto ON produto.artigo = venda_produto.cod_produto"
                + "        WHERE venda_produto.nf = ?;"; 
        
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setInt(1, nf);
        ResultSet result = statment.executeQuery();
        List<Venda_Produto> vendas = new ArrayList<>();
        while (result.next()){
            vendas.add(new Venda_Produto(new Produto(result.getInt(1), result.getDouble(2), result.getInt(3), result.getString(4)), //produto
                       result.getInt(5), //notaFiscal
                       result.getInt(7), //quantidade
                       result.getDouble(7))); //valorDoItem
        }
        connection.close();
        return vendas;
    }
    
}
