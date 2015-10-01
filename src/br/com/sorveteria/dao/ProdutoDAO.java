package br.com.sorveteria.dao;

import br.com.sorveteria.models.ProdutoModel;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class ProdutoDAO {

    public List<ProdutoModel> consultaPeloID(ProdutoModel produtoModel) {
        String SQL = "SELECT * FROM produtos WHERE idproduto = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, produtoModel.getIdProduto());
            ResultSet rs = pst.executeQuery();
            List<ProdutoModel> produto = new ArrayList<>();
            if (rs.first()) {
                ProdutoModel data = new ProdutoModel();
                data.setIdProduto(rs.getInt(1));
                data.setDescricao(rs.getString(2));
                data.setSaldoProduto(rs.getDouble(3));
                data.setPrecoVendaProduto(rs.getDouble(4));
                data.setStatus(rs.getInt(5));
                produto.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return produto;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o produto!\n\n" + ex.getMessage());
        }
        return null;
    }

    public List<ProdutoModel> consultaPeloNome(ProdutoModel produtoModel) {
        String SQL = "SELECT * FROM produtos WHERE descricao LIKE ? ORDER BY descricao ASC";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, "%" + produtoModel.getDescricao() + "%");
            ResultSet rs = pst.executeQuery();
            List<ProdutoModel> produtos = new ArrayList<>();
            while (rs.next()) {
                ProdutoModel data = new ProdutoModel();
                data.setIdProduto(rs.getInt(1));
                data.setDescricao(rs.getString(2));
                data.setSaldoProduto(rs.getDouble(3));
                data.setPrecoVendaProduto(rs.getDouble(4));
                data.setStatus(rs.getInt(5));
                produtos.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return produtos;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar os produtos!\n\n" + ex.getMessage());
        }
        return null;
    }

    public List<ProdutoModel> consultaPeloNomeIgual(ProdutoModel produtoModel) {
        String SQL = "SELECT * FROM produtos WHERE descricao = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, produtoModel.getDescricao());
            ResultSet rs = pst.executeQuery();
            List<ProdutoModel> produto = new ArrayList<>();
            if (rs.first()) {
                ProdutoModel data = new ProdutoModel();
                data.setIdProduto(rs.getInt(1));
                data.setDescricao(rs.getString(2));
                data.setSaldoProduto(rs.getDouble(3));
                data.setPrecoVendaProduto(rs.getDouble(4));
                data.setStatus(rs.getInt(5));
                produto.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return produto;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o produto!\n\n" + ex.getMessage());
        }

        return null;
    }

    public void cadastra(ProdutoModel produtoModel) {
        String SQL = "INSERT INTO produtos (descricao, saldoproduto, precovenda, status) VALUES (?,?,?,?)";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, produtoModel.getDescricao());
            pst.setDouble(2, produtoModel.getSaldoProduto());
            pst.setDouble(3, produtoModel.getPrecoVendaProduto());
            pst.setInt(4, produtoModel.getStatus());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o produto!\n\n" + ex.getMessage());
        }
    }

    public void atualiza(ProdutoModel produtoModel) {
        String SQL = "UPDATE produtos SET descricao = ?, precovenda = ?, status = ? WHERE idproduto = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, produtoModel.getDescricao());
            pst.setDouble(2, produtoModel.getPrecoVendaProduto());
            pst.setInt(3, produtoModel.getStatus());
            pst.setInt(4, produtoModel.getIdProduto());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar o produto!\n\n" + ex.getMessage());
        }
    }

    public Double pegaSaldoPeloID(ProdutoModel produtoModel) {
        String SQL = "SELECT saldoproduto FROM produtos WHERE idproduto = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, produtoModel.getIdProduto());
            ResultSet rs = pst.executeQuery();
            Double saldo = 0.0;
            if (rs.first()) {
                saldo = rs.getDouble(1);
            }
            rs.close();
            pst.close();
            connection.close();
            return saldo;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar o produto!\n\n" + ex.getMessage());
        }
        return null;
    }

    public void entrada(ProdutoModel produtoModel) {
        String SQL = "UPDATE produtos SET saldoproduto = saldoproduto + ? WHERE idproduto = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setDouble(1, produtoModel.getQuantidade());
            pst.setInt(2, produtoModel.getIdProduto());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Entrada realizada com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar lançar entrada do produto!\n\n" + ex.getMessage());
        }

    }

    public void saida(ProdutoModel produtoModel) {
        String SQL = "UPDATE produtos SET saldoproduto = saldoproduto - ? WHERE idproduto = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setDouble(1, produtoModel.getQuantidade());
            pst.setInt(2, produtoModel.getIdProduto());
            pst.execute();
            pst.close();
            connection.close();
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar lançar entrada do produto!\n\n" + ex.getMessage());
        }
    }
}
