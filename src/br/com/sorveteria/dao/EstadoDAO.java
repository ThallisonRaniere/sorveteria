package br.com.sorveteria.dao;

import java.util.List;
import br.com.sorveteria.models.EstadoModel;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class EstadoDAO {

    //ok
    public List<EstadoModel> consultaPeloID(EstadoModel estadoModel) {
        String SQL = "SELECT uf, status FROM estados WHERE idestado = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, estadoModel.getIdEstado());
            ResultSet rs = pst.executeQuery();
            List<EstadoModel> estado = new ArrayList<>();
            estado.clear();
            if (rs.first()) {
                EstadoModel data = new EstadoModel();
                data.setSiglaEstado(rs.getString(1));
                data.setStatus(rs.getInt(2));
                estado.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return estado;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao obter o estado pelo ID!\n\n" + ex.getMessage());
        }
        return null;
    }

    //ok
    public List<EstadoModel> consultaPeloNome(EstadoModel estadoModel) {
        String SQL = "SELECT idestado, uf, status FROM estados WHERE uf LIKE ? ORDER BY uf ASC";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, estadoModel.getSiglaEstado().replaceAll("'", "") + "%");
            ResultSet rs = pst.executeQuery();
            List<EstadoModel> estados = new ArrayList<>();
            estados.clear();
            while (rs.next()) {
                EstadoModel data = new EstadoModel();
                data.setIdEstado(rs.getInt(1));
                data.setSiglaEstado(rs.getString(2));
                data.setStatus(rs.getInt(3));
                estados.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return estados;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao obter o estado pelo NOME!\n\n" + ex.getMessage());
        }
        return null;
    }

    //ok
    public List<EstadoModel> consultaPeloNomeIgual(EstadoModel estadoModel) {
        String SQL = "SELECT idestado, uf, status FROM estados WHERE uf = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, estadoModel.getSiglaEstado().replaceAll("'", ""));
            ResultSet rs = pst.executeQuery();
            List<EstadoModel> estados = new ArrayList<>();
            estados.clear();
            while (rs.next()) {
                EstadoModel data = new EstadoModel();
                data.setIdEstado(rs.getInt(1));
                data.setSiglaEstado(rs.getString(2));
                data.setStatus(rs.getInt(3));
                estados.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return estados;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao obter o estado pelo NOME!\n\n" + ex.getMessage());
        }
        return null;
    }

    //ok
    public void cadastra(EstadoModel estadoModel) {
        String SQL = "INSERT INTO estados (uf, status) VALUES (?,?)";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, estadoModel.getSiglaEstado());
            pst.setInt(2, estadoModel.getStatus());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Estado cadastrado com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o estado!\n\n" + ex.getMessage());
        }
    }

    //ok
    public void atualiza(EstadoModel estadoModel) {
        String SQL = "UPDATE estados SET uf = ?, status = ? WHERE idestado = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, estadoModel.getSiglaEstado());
            pst.setInt(2, estadoModel.getStatus());
            pst.setInt(3, estadoModel.getIdEstado());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Estado atualizado com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar o estado!\n\n" + ex.getMessage());
        }
    }

    //ok
    public void atualizaStatus(EstadoModel estadoModel) {
        String SQL = "UPDATE estados SET status = ? WHERE idestado = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, estadoModel.getStatus());
            pst.setInt(2, estadoModel.getIdEstado());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Status do estado atualizado com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar o estado!\n\n" + ex.getMessage());
        }
    }

    public List<EstadoModel> getAll() {
        String SQL = "SELECT * FROM estados ORDER BY uf ASC";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();
            List<EstadoModel> estados = new ArrayList<>();
            estados.clear();
            while (rs.next()) {
                EstadoModel data = new EstadoModel();
                data.setIdEstado(rs.getInt(1));
                data.setSiglaEstado(rs.getString(2));
                data.setStatus(rs.getInt(3));
                estados.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return estados;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao obter o estado pelo NOME!\n\n" + ex.getMessage());
        }
        return null;
    }

}
