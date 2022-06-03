package dao;

import com.mycompany.projetoa3.Connexao_SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;


public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO() throws SQLException {
        connection = Connexao_SQL.getConnection();
    }
    
    //insere um produto no banco de dados
    public boolean insertProduto(Produto produto) throws SQLException{
        String sqlQuery = "INSERT INTO produto (preco, qtde_produto, descricao) VALUES (?,?,?)";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setDouble(1, produto.getPreco());
        statment.setInt(2, produto.getQtde_produto());
        statment.setString(3, produto.getDescricao());
        int rowsInserted = statment.executeUpdate();      
        return (rowsInserted > 0);
    }
    
    //atualiza um produto do banco de dados
    public boolean updateProduto(Produto produto) throws SQLException{
        String sqlQuery = "UPDATE produto SET preco = ?, qtde_produto = ?, descricao = ? WHERE artigo = ?";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setDouble(1, produto.getPreco());
        statment.setInt(2, produto.getQtde_produto());
        statment.setString(3, produto.getDescricao());
        statment.setInt(4, produto.getArtigo());
        int rowsAffected = statment.executeUpdate();  
        return (rowsAffected > 0);
    }
    
    //remove um produto do banco de dados
    public boolean deleteProduto(int artigo) throws SQLException{
        String sqlQuery = "DELETE FROM produto WHERE artigo = ?";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setInt(1, artigo);
        int rowsAffected = statment.executeUpdate();  
        return (rowsAffected > 0);      
    }
    
    //encontra produto por artigo (id)
    public Produto findProduto(int artigo) throws SQLException{
        String sqlQuery = "SELECT artigo, preco, qtde_produto, descricao FROM produto WHERE artigo = ?";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setInt(1, artigo);
        ResultSet result = statment.executeQuery();
        if (result.next())
            return new Produto(result.getInt(1), result.getDouble(2), result.getInt(3), result.getString(4));
        else
            return null;
    }
    
    //retorna lista com todos os produtos com certa descricao
    public List<Produto> findProdutoByDescricao(String descricao) throws SQLException{
        String sqlQuery = "SELECT artigo, preco, qtde_produto, descricao FROM produto WHERE descricao LIKE ?";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        statment.setString(1, "%" + descricao + "%");
        ResultSet result = statment.executeQuery();
        List<Produto> produtos = new ArrayList<>();
        while (result.next()){
            produtos.add(new Produto(result.getInt(1), result.getDouble(2), result.getInt(3), result.getString(4)));
        }       
        return produtos;
    }
    
    //retorna lista com todos os produtos cadastrados
    public List<Produto> findAllProduto() throws SQLException{
        String sqlQuery = "SELECT artigo, preco, qtde_produto, descricao FROM produto";
        PreparedStatement statment = connection.prepareStatement(sqlQuery);
        ResultSet result = statment.executeQuery();
        List<Produto> produtos = new ArrayList<>();
        while (result.next()){
            produtos.add(new Produto(result.getInt(1), result.getDouble(2), result.getInt(3), result.getString(4)));
        }       
        return produtos;
    }
}
