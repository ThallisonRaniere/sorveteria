package br.com.sorveteria.dao;

import br.com.sorveteria.controllers.ProdutoController;
import br.com.sorveteria.models.ItemVendaModel;
import br.com.sorveteria.models.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class ItensVendaDAO {

    public Double valorTotalVenda(Integer codigoVenda) {
        String SQL = "SELECT SUM(valortotalitem) FROM itensvenda WHERE cabecalhovenda_idvenda = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, codigoVenda);
            ResultSet rs = pst.executeQuery();
            Double valorTotal = 0.0;
            if (rs.first()) {
                valorTotal = rs.getDouble(1);
            }
            rs.close();
            pst.close();
            connection.close();
            return valorTotal;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro retorno de valor!\n\n" + ex.getMessage());
        }

        return null;
    }

    public List<ItemVendaModel> consultaPeloIdVenda(Integer codigoVenda) {
        String SQL = "SELECT i.iditem, i.item, i.cabecalhovenda_idvenda,"
                + " i.idproduto, p.descricao, i.quantidade, i.precovenda,i.valortotalitem"
                + " FROM itensvenda i "
                + " INNER JOIN produtos p ON p.idproduto = i.idproduto"
                + " WHERE i.cabecalhovenda_idvenda = ?"
                + " ORDER BY i.item ASC";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, codigoVenda);
            ResultSet rs = pst.executeQuery();
            List<ItemVendaModel> itens = new ArrayList<>();
            itens.clear();
            while (rs.next()) {
                ItemVendaModel data = new ItemVendaModel();
                data.setIdItemVenda(rs.getInt(1));
                data.setItem(rs.getInt(2));
                data.setIdVenda(rs.getInt(3));
                data.setIdProduto(rs.getInt(4));
                data.setDescricao(rs.getString(5));
                data.setQuantidade(rs.getDouble(6));
                data.setPrecoVendaProduto(rs.getDouble(7));
                data.setValorTotalItem(rs.getDouble(8));
                itens.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return itens;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro retorno de dados!\n\n" + ex.getMessage());
        }
        return null;
    }

    public void cadastraItensVenda(List<ItemVendaModel> itensVenda) {
        String SQL = "INSERT INTO itensvenda (item, cabecalhovenda_idvenda, idproduto, quantidade, precovenda, valortotalitem) VALUES (?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement pst = null;
        for (ItemVendaModel ivm : itensVenda) {
            try {
                connection = Conexao.Conecta();
                pst = connection.prepareStatement(SQL);
                pst.setInt(1, ivm.getItem());
                pst.setInt(2, ivm.getIdVenda());
                pst.setInt(3, ivm.getIdProduto());
                pst.setDouble(4, ivm.getQuantidade());
                pst.setDouble(5, ivm.getPrecoVendaProduto());
                pst.setDouble(6, ivm.getValorTotalItem());
                pst.execute();
                ProdutoModel p = new ProdutoModel();
                ProdutoController pc = new ProdutoController();
                p.setIdProduto(ivm.getIdProduto());
                p.setQuantidade(ivm.getQuantidade());
                pc.saidaestoque(p);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar os itens!\n\n" + ex.getMessage());
            }
        }
        JOptionPane.showMessageDialog(null, "Produtos adicionados com sucesso!");
        try {
            pst.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!\n\n" + e.getMessage());
        }
    }

}
