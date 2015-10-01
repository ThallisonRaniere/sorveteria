package br.com.sorveteria.controllers;

import br.com.sorveteria.dao.ClienteDAO;
import br.com.sorveteria.models.ClienteModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class ClienteController {

    public List<ClienteModel> consultaPeloID(ClienteModel clienteModel) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.consultaPeloID(clienteModel);
    }

    public String consultaPeloNomeID(Integer id) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.consultaNomeCliente(id);
    }

    public List<ClienteModel> consultaPeloNome(ClienteModel clienteModel) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.consultaPeloNome(clienteModel);
    }

    public List<ClienteModel> consultaPeloNomeIgual(ClienteModel clienteModel) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.consultaPeloNomeIgual(clienteModel);
    }

    public Boolean cadastra(ClienteModel clienteModel) {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<ClienteModel> data = consultaPeloNomeIgual(clienteModel);
        if (data.size() <= 0) {
            clienteDAO.cadastra(clienteModel);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Já tem um cliente cadastrado com esse nome no banco de dados!");
            return false;
        }
    }

    public Boolean atualiza(ClienteModel clienteModel) {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<ClienteModel> data = consultaPeloID(clienteModel);
        if (data.size() > 0) {
            clienteDAO.atualiza(clienteModel);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Por favor verifique o cliente que você está tentando atualizar!");
            return false;
        }
    }

    public Boolean atualizaStatus(ClienteModel clienteModel) {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<ClienteModel> data = consultaPeloID(clienteModel);
        if (data.size() > 0) {
            clienteDAO.atualizaStatus(clienteModel);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Por favor verifique o cliente que você está tentando atualizar!");
            return false;
        }
    }
}
