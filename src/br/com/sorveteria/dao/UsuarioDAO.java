package br.com.sorveteria.dao;

import br.com.sorveteria.models.UsuarioModel;
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
public class UsuarioDAO {

    public List<UsuarioModel> consultaPeloID(UsuarioModel usuarioModel) {
        String SQL = "SELECT nomeusuario, cpfusuario, cepusuario, numerologradourousuario, idcidade, loginusuario, status FROM usuarios WHERE idusuario = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, usuarioModel.getIdUsuario());
            ResultSet rs = pst.executeQuery();
            List<UsuarioModel> usuario = new ArrayList<>();
            usuario.clear();
            if (rs.first()) {
                UsuarioModel data = new UsuarioModel();
                data.setNomeUsuario(rs.getString(1));
                data.setCpfUsuario(rs.getString(2));
                data.setCepUsuario(rs.getString(3));
                data.setNumeroLogradouroUsuario(rs.getInt(4));
                data.setIdCidade(rs.getInt(5));
                data.setLoginUsuario(rs.getString(6));
                data.setStatus(rs.getInt(7));
                usuario.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return usuario;
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o cadastro do usuário!\n\n" + ex.getMessage());
        }
        return null;
    }

    public List<UsuarioModel> consultaPeloNome(UsuarioModel usuarioModel) {
        String SQL = "SELECT usuarios.idusuario, usuarios.nomeusuario, usuarios.cpfusuario, usuarios.cepusuario, usuarios.numerologradourousuario,"
                + "usuarios.idcidade, cidades.nomecidade, estados.uf, usuarios.loginusuario, usuarios.status from usuarios "
                + "inner join cidades on (cidades.idcidade = usuarios.idcidade) "
                + "inner join estados on (estados.idestado = cidades.idestado) "
                + "where usuarios.nomeusuario like ? order by usuarios.nomeusuario ASC";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, "%" + usuarioModel.getNomeUsuario() + "%");
            ResultSet rs = pst.executeQuery();
            List<UsuarioModel> usuarios = new ArrayList<>();
            usuarios.clear();
            while (rs.next()) {
                UsuarioModel data = new UsuarioModel();
                data.setIdUsuario(rs.getInt(1));
                data.setNomeUsuario(rs.getString(2));
                data.setCpfUsuario(rs.getString(3));
                data.setCepUsuario(rs.getString(4));
                data.setNumeroLogradouroUsuario(rs.getInt(5));
                data.setIdCidade(rs.getInt(6));
                data.setNomeCidade(rs.getString(7));
                data.setSiglaEstado(rs.getString(8));
                data.setLoginUsuario(rs.getString(9));
                data.setStatus(rs.getInt(10));
                usuarios.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return usuarios;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o cadastro do usuário!\n\n" + ex.getMessage());
        }

        return null;
    }

    public List<UsuarioModel> consultaPeloNomeIgual(UsuarioModel usuarioModel) {
        String SQL = "SELECT idusuario, nomeusuario, cpfusuario, cepusuario, numerologradourousuario, idcidade, loginusuario, status FROM usuarios WHERE nomeusuario = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, usuarioModel.getNomeUsuario());
            ResultSet rs = pst.executeQuery();
            List<UsuarioModel> usuarios = new ArrayList<>();
            usuarios.clear();
            while (rs.next()) {
                UsuarioModel data = new UsuarioModel();
                data.setIdUsuario(rs.getInt(1));
                data.setNomeUsuario(rs.getString(2));
                data.setCpfUsuario(rs.getString(3));
                data.setCepUsuario(rs.getString(4));
                data.setNumeroLogradouroUsuario(rs.getInt(5));
                data.setIdCidade(rs.getInt(6));
                data.setLoginUsuario(rs.getString(7));
                data.setStatus(rs.getInt(8));
                usuarios.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return usuarios;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o cadastro do usuário!\n\n" + ex.getMessage());
        }
        return null;
    }

    public void cadastra(UsuarioModel usuarioModel) {
        String SQL = "INSERT INTO usuarios (nomeusuario, cpfusuario, cepusuario, numerologradourousuario, idcidade, loginusuario, senhausuario, status) VALUES (?,?,?,?,?,?,?,?)";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, usuarioModel.getNomeUsuario());
            pst.setString(2, usuarioModel.getCpfUsuario());
            pst.setString(3, usuarioModel.getCepUsuario());
            pst.setInt(4, usuarioModel.getNumeroLogradouroUsuario());
            pst.setInt(5, usuarioModel.getIdCidade());
            pst.setString(6, usuarioModel.getLoginUsuario());
            pst.setString(7, usuarioModel.getSenhaUsuario());
            pst.setInt(8, usuarioModel.getStatus());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o usuário!\n\n" + ex.getMessage());
        }
    }

    public void atualiza(UsuarioModel usuarioModel) {
        String SQL = "UPDATE usuarios SET nomeusuario = ?, cpfusuario = ?, cepusuario = ?, numerologradourousuario = ?, idcidade = ?, loginusuario = ?, senhausuario = ?, status = ? WHERE idusuario = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, usuarioModel.getNomeUsuario());
            pst.setString(2, usuarioModel.getCpfUsuario());
            pst.setString(3, usuarioModel.getCepUsuario());
            pst.setInt(4, usuarioModel.getNumeroLogradouroUsuario());
            pst.setInt(5, usuarioModel.getIdCidade());
            pst.setString(6, usuarioModel.getLoginUsuario());
            pst.setString(7, usuarioModel.getSenhaUsuario());
            pst.setInt(8, usuarioModel.getStatus());
            pst.setInt(9, usuarioModel.getIdUsuario());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Cadastro de usuário atualizado com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar o cadastro do usuário!\n\n" + ex.getMessage());
        }

    }

    public Boolean validaLoginUsuario(UsuarioModel usuarioModel) {
        String SQL = "SELECT loginusuario, senhausuario FROM usuarios WHERE loginusuario = ? AND senhausuario = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, usuarioModel.getLoginUsuario());
            pst.setString(2, usuarioModel.getSenhaUsuario());
            ResultSet rs = pst.executeQuery();
            if (rs.first()) {
                //JOptionPane.showMessageDialog(null, "Bem-vindo ao sistema!");
                return true;
            }
            rs.close();
            pst.close();
            connection.close();
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o login do usuário!\n\n" + ex.getMessage());
        }
        return false;
    }

    public boolean buscaLogin(String login, int cod) {
        updateLogin(cod);
        String SQL = "SELECT * FROM usuarios WHERE loginusuario = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();
            if (rs.first()) {
                return true;
            }
            rs.close();
            pst.close();
            connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o cadastro do usuário!\n\n" + ex.getMessage());
        }
        return false;
    }

    public void updateLogin(int cod) {
        String SQL = "UPDATE usuarios SET loginusuario = 'default' WHERE idusuario = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, cod);
            pst.execute();
            pst.close();
            connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro:\n\n" + ex.getMessage());
        }
    }

    public String consultaNomeUsuario(Integer id) {
        String SQL = "SELECT nomeusuario FROM usuarios WHERE idusuario = ?";
        String nome = null;
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.first()) {
                nome = rs.getString(1);
            } else {
                JOptionPane.showMessageDialog(null, "Não tem usuario cadastrado com esse ID!");
            }
            rs.close();
            pst.close();
            connection.close();
            return nome;
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o cliente!\n\n" + ex.getMessage());
            return null;
        }
    }
}
