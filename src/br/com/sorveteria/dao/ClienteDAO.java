package br.com.sorveteria.dao;

import br.com.sorveteria.models.ClienteModel;
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
public class ClienteDAO {

    public List<ClienteModel> consultaPeloID(ClienteModel clienteModel) {
        String SQL = "SELECT cpfcliente, cnpjcliente, nomecliente, contatocliente, emailcliente, cepcliente, numerologradourocliente, idcidade, status FROM clientes WHERE idcliente = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, clienteModel.getIdCliente());
            ResultSet rs = pst.executeQuery();
            List<ClienteModel> cliente = new ArrayList<>();
            cliente.clear();
            if (rs.first()) {
                ClienteModel data = new ClienteModel();
                data.setCpfCliente(rs.getString(1));
                data.setCnpjCliente(rs.getString(2));
                data.setNomeCliente(rs.getString(3));
                data.setContatoCliente(rs.getString(4));
                data.setEmailCliente(rs.getString(5));
                data.setCepCliente(rs.getString(6));
                data.setNumeroLogradouroCliente(rs.getInt(7));
                data.setIdCidade(rs.getInt(8));
                data.setStatus(rs.getInt(9));
                cliente.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return cliente;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o cliente!\n\n" + ex.getMessage());
        }
        return null;
    }

    public List<ClienteModel> consultaPeloNome(ClienteModel clienteModel) {
        String SQL = "SELECT c.idcliente, c.cpfcliente, c.cnpjcliente, c.nomecliente, c.contatocliente, c.emailcliente, "
                + "c.cepcliente, c.numerologradourocliente, c.idcidade, cidades.nomecidade, estados.uf, c.status FROM clientes c "
                + "INNER JOIN cidades ON cidades.idcidade = c.idcidade "
                + "INNER JOIN estados ON estados.idestado = cidades.idestado "
                + "WHERE c.nomecliente LIKE ? ORDER BY c.nomecliente ASC";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, "%" + clienteModel.getNomeCliente() + "%");
            ResultSet rs = pst.executeQuery();
            List<ClienteModel> clientes = new ArrayList<>();
            clientes.clear();
            while (rs.next()) {
                ClienteModel data = new ClienteModel();
                data.setIdCliente(rs.getInt(1));
                data.setCpfCliente(rs.getString(2));
                data.setCnpjCliente(rs.getString(3));
                data.setNomeCliente(rs.getString(4));
                data.setContatoCliente(rs.getString(5));
                data.setEmailCliente(rs.getString(6));
                data.setCepCliente(rs.getString(7));
                data.setNumeroLogradouroCliente(rs.getInt(8));
                data.setIdCidade(rs.getInt(9));
                data.setNomeCidade(rs.getString(10));
                data.setSiglaEstado(rs.getString(11));
                data.setStatus(rs.getInt(12));
                clientes.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return clientes;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o cliente!\n\n" + ex.getMessage());
        }
        return null;
    }

    public List<ClienteModel> consultaPeloNomeIgual(ClienteModel clienteModel) {
        String SQL = "SELECT idcliente, cpfcliente, cnpjcliente, nomecliente, contatocliente, emailcliente, cepcliente, numerologradourocliente, idcidade, status FROM clientes WHERE nomecliente = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, clienteModel.getNomeCliente());
            ResultSet rs = pst.executeQuery();
            List<ClienteModel> clientes = new ArrayList<>();
            clientes.clear();
            while (rs.next()) {
                ClienteModel data = new ClienteModel();
                data.setIdCliente(rs.getInt(1));
                data.setCpfCliente(rs.getString(2));
                data.setCnpjCliente(rs.getString(3));
                data.setNomeCliente(rs.getString(4));
                data.setContatoCliente(rs.getString(5));
                data.setEmailCliente(rs.getString(6));
                data.setCepCliente(rs.getString(7));
                data.setNumeroLogradouroCliente(rs.getInt(8));
                data.setIdCidade(rs.getInt(9));
                data.setStatus(rs.getInt(10));
                clientes.add(data);
            }
            rs.close();
            pst.close();
            connection.close();
            return clientes;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o cliente!\n\n" + ex.getMessage());
        }
        return null;
    }

    public void cadastra(ClienteModel clienteModel) {
        String SQL = "INSERT INTO clientes (cpfcliente, cnpjcliente, nomecliente, contatocliente, emailcliente, cepcliente, numerologradourocliente, idcidade, status) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, clienteModel.getCpfCliente());
            pst.setString(2, clienteModel.getCnpjCliente());
            pst.setString(3, clienteModel.getNomeCliente());
            pst.setString(4, clienteModel.getContatoCliente());
            pst.setString(5, clienteModel.getEmailCliente());
            pst.setString(6, clienteModel.getCepCliente());
            pst.setInt(7, clienteModel.getNumeroLogradouroCliente());
            pst.setInt(8, clienteModel.getIdCidade());
            pst.setInt(9, clienteModel.getStatus());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o cliente!\n\n" + ex.getMessage());
        }

    }

    public void atualiza(ClienteModel clienteModel) {
        String SQL = "UPDATE clientes SET cpfcliente = ?, cnpjcliente = ?, nomecliente = ?, contatocliente = ?, emailcliente = ?, cepcliente = ?, numerologradourocliente = ?, idcidade = ?, status = ? WHERE idcliente = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, clienteModel.getCpfCliente());
            pst.setString(2, clienteModel.getCnpjCliente());
            pst.setString(3, clienteModel.getNomeCliente());
            pst.setString(4, clienteModel.getContatoCliente());
            pst.setString(5, clienteModel.getEmailCliente());
            pst.setString(6, clienteModel.getCepCliente());
            pst.setInt(7, clienteModel.getNumeroLogradouroCliente());
            pst.setInt(8, clienteModel.getIdCidade());
            pst.setInt(9, clienteModel.getStatus());
            pst.setInt(10, clienteModel.getIdCliente());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Cadastro do cliente atualizado com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar o cadastro do cliente!\n\n" + ex.getMessage());
        }
    }

    public void atualizaStatus(ClienteModel clienteModel) {
        String SQL = "UPDATE clientes SET status = ? WHERE idcliente = ?";
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, clienteModel.getStatus());
            pst.setInt(2, clienteModel.getIdCliente());
            pst.execute();
            pst.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Status do cliente atualizado com sucesso!");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar o status do cliente!\n\n" + ex.getMessage());
        }
    }

    public String consultaNomeCliente(Integer id) {
        String SQL = "SELECT nomecliente FROM clientes WHERE idcliente = ?";
        String nome = null;
        try {
            Connection connection = Conexao.Conecta();
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.first()) {
                nome = rs.getString(1);
            } else {
                JOptionPane.showMessageDialog(null, "Não tem cliente cadastrado com esse ID!");
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
