package br.com.sorveteria.dao;

import br.com.sorveteria.models.CabecalhoVendaModel;
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
public class CabecalhoVendaDAO {

    public List<CabecalhoVendaModel> getVendasAbertas() {
        String SQL = "SELECT c.idvenda, c.datavenda, c.idcliente, a.nomecliente, "
                + "c.idusuario, u.nomeusuario, c.observacoesvenda "
                + "FROM cabecalhovenda c "
                + "INNER JOIN clientes a ON (a.idcliente = c.idcliente) "
                + "INNER JOIN usuarios u ON (u.idusuario = c.idusuario) "
                + "WHERE c.status = 0 ORDER BY c.idvenda DESC";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();
            List<CabecalhoVendaModel> vendas = new ArrayList<>();
            vendas.clear();
            while (rs.next()) {
                CabecalhoVendaModel data = new CabecalhoVendaModel();
                data.setIdVenda(rs.getInt(1));
                data.setDataVenda(rs.getDate(2).toString());
                data.setIdCliente(rs.getInt(3));
                data.setNomeCliente(rs.getString(4));
                data.setIdUsuario(rs.getInt(5));
                data.setNomeUsuario(rs.getString(6));
                data.setObservacoesVenda(rs.getString(7));
                vendas.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return vendas;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar vendas abertas!\n\n" + ex.getMessage());
        }
        return null;
    }

    public List<CabecalhoVendaModel> getAll() {
        String SQL = "SELECT c.idvenda, c.datavenda, c.idcliente, a.nomecliente, "
                + "c.idusuario, u.nomeusuario, c.observacoesvenda, c.valortotal, c.status "
                + "FROM cabecalhovenda c "
                + "INNER JOIN clientes a ON (a.idcliente = c.idcliente) "
                + "INNER JOIN usuarios u ON (u.idusuario = c.idusuario) "
                + " ORDER BY c.idvenda DESC";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();
            List<CabecalhoVendaModel> vendas = new ArrayList<>();
            vendas.clear();
            while (rs.next()) {
                CabecalhoVendaModel data = new CabecalhoVendaModel();
                data.setIdVenda(rs.getInt(1));
                data.setDataVenda(rs.getDate(2).toString());
                data.setIdCliente(rs.getInt(3));
                data.setNomeCliente(rs.getString(4));
                data.setIdUsuario(rs.getInt(5));
                data.setNomeUsuario(rs.getString(6));
                data.setObservacoesVenda(rs.getString(7));
                data.setValorTotal(rs.getDouble(8));
                data.setStatus(rs.getInt(9));
                vendas.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return vendas;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar vendas abertas!\n\n" + ex.getMessage());
        }
        return null;
    }

    public void cadastra(CabecalhoVendaModel cabecalhoVendaModel) {
        String dia = cabecalhoVendaModel.getDataVenda().substring(0, 2);
        String mes = cabecalhoVendaModel.getDataVenda().substring(3, 5);
        String ano = cabecalhoVendaModel.getDataVenda().substring(6);
        String dataMySql = ano + "-" + mes + "-" + dia;
        String SQL = "INSERT INTO cabecalhovenda (datavenda, idcliente, idusuario, observacoesvenda, valortotal, status) VALUES (?,?,?,?,?,?)";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, dataMySql);
            pst.setInt(2, cabecalhoVendaModel.getIdCliente());
            pst.setInt(3, cabecalhoVendaModel.getIdUsuario());
            pst.setString(4, cabecalhoVendaModel.getObservacoesVenda());
            pst.setDouble(5, 0.00);
            pst.setInt(6, cabecalhoVendaModel.getStatus());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar registrar lançamento de venda!\n\n" + ex.getMessage());
        }
    }

    public void finalizaVenda(CabecalhoVendaModel cvm) {
        String SQL = "UPDATE cabecalhovenda SET valortotal = ?, status = 1 WHERE idvenda = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setDouble(1, cvm.getValorTotal());
            pst.setInt(2, cvm.getIdVenda());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Venda finalizada com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao finalizar a venda!\n\n" + ex.getMessage());
        }
    }
}
