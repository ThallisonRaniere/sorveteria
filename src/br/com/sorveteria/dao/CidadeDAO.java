package br.com.sorveteria.dao;

import br.com.sorveteria.models.CidadeModel;
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
public class CidadeDAO {

    //ok
    public List<CidadeModel> consultaPeloID(CidadeModel cidadeModel) {
        String SQL = "SELECT nomecidade, idestado, status FROM cidades WHERE idcidade = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, cidadeModel.getIdCidade());
            ResultSet rs = pst.executeQuery();
            List<CidadeModel> cidade = new ArrayList<>();
            cidade.clear();
            if (rs.first()) {
                CidadeModel data = new CidadeModel();
                data.setNomeCidade(rs.getString(1));
                data.setIdEstado(rs.getInt(2));
                data.setStatus(rs.getInt(3));
                cidade.add(data);
            }
            return cidade;
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar a cidade!\n\n" + ex.getMessage());
        }
        return null;
    }

    //ok
    public List<CidadeModel> consultaPeloNome(CidadeModel cidadeModel) {
        String SQL = "SELECT idcidade, nomecidade, idestado, status FROM cidades WHERE nomecidade LIKE ? ORDER BY nomecidade ASC";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, "%" + cidadeModel.getNomeCidade().replaceAll("'", "") + "%");
            ResultSet rs = pst.executeQuery();
            List<CidadeModel> cidade = new ArrayList<>();
            while (rs.next()) {
                CidadeModel data = new CidadeModel();
                data.setIdCidade(rs.getInt(1));
                data.setNomeCidade(rs.getString(2));
                data.setIdEstado(rs.getInt(3));
                data.setStatus(rs.getInt(4));
                cidade.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return cidade;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar a cidade!\n\n" + ex.getMessage());
        }
        return null;
    }

    //ok
    public List<CidadeModel> consultaPeloNomeAndEstado(CidadeModel cidadeModel) {
        String SQL = "SELECT idcidade, nomecidade, idestado, status FROM cidades WHERE nomecidade = ? AND idestado = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, cidadeModel.getNomeCidade().replaceAll("'", ""));
            pst.setInt(2, cidadeModel.getIdEstado());
            ResultSet rs = pst.executeQuery();
            List<CidadeModel> cidade = new ArrayList<>();
            while (rs.next()) {
                CidadeModel data = new CidadeModel();
                data.setIdCidade(rs.getInt(1));
                data.setNomeCidade(rs.getString(2));
                data.setIdEstado(rs.getInt(3));
                data.setStatus(rs.getInt(4));
                cidade.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return cidade;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar a cidade!\n\n" + ex.getMessage());
        }
        return null;
    }

    //ok
    public void cadastra(CidadeModel cidadeModel) {
        String SQL = "INSERT INTO cidades (nomecidade, idestado, status) VALUES (?,?,?)";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, cidadeModel.getNomeCidade());
            pst.setInt(2, cidadeModel.getIdEstado());
            pst.setInt(3, cidadeModel.getStatus());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a cidade!\n\n" + ex.getMessage());
        }
    }

    //ok
    public void atualiza(CidadeModel cidadeModel) {
        String SQL = "UPDATE cidades SET nomecidade = ?, idestado = ?, status = ? WHERE idcidade = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, cidadeModel.getNomeCidade());
            pst.setInt(2, cidadeModel.getIdEstado());
            pst.setInt(3, cidadeModel.getStatus());
            pst.setInt(4, cidadeModel.getIdCidade());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Cidade atualizada com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar o cadastro da cidade!\n\n" + ex.getMessage());
        }
    }

    //ok
    public void atualizarStatus(CidadeModel cidadeModel) {
        String SQL = "UPDATE cidades SET status = ? WHERE idcidade = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, cidadeModel.getStatus());
            pst.setInt(2, cidadeModel.getIdCidade());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Status da cidade atualizado com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar o status da cidade!\n\n" + ex.getMessage());
        }
    }

    public List<CidadeModel> consultaPeloIdEstado(Integer cod) {
        String SQL = "SELECT * FROM cidades WHERE idestado = ? ORDER BY nomecidade ASC";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, cod);
            ResultSet rs = pst.executeQuery();
            List<CidadeModel> cidades = new ArrayList<>();
            cidades.clear();
            while (rs.next()) {
                CidadeModel data = new CidadeModel();
                data.setIdCidade(rs.getInt(1));
                data.setNomeCidade(rs.getString(2));
                data.setIdEstado(rs.getInt(3));
                data.setStatus(rs.getInt(4));
                cidades.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return cidades;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar as cidades!\n\n" + ex.getMessage());
        }
        return null;
    }

    public List<CidadeModel> getCidadesEstado(CidadeModel cidadeModel) {
        String SQL = "SELECT cidades.idcidade, cidades.nomecidade, estados.uf, cidades.status FROM cidades INNER JOIN estados ON (estados.idestado = cidades.idestado) WHERE cidades.nomecidade LIKE ? ORDER BY cidades.nomecidade ASC";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, "%" + cidadeModel.getNomeCidade() + "%");
            ResultSet rs = pst.executeQuery();
            List<CidadeModel> cidades = new ArrayList<>();
            cidades.clear();
            while (rs.next()) {
                CidadeModel data = new CidadeModel();
                data.setIdCidade(rs.getInt(1));
                data.setNomeCidade(rs.getString(2));
                data.setSiglaEstado(rs.getString(3));
                data.setStatus(rs.getInt(4));
                cidades.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return cidades;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar as cidades!\n\n" + ex.getMessage());
        }

        return null;
    }

}
