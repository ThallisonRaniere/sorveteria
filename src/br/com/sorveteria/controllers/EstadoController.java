package br.com.sorveteria.controllers;

import br.com.sorveteria.dao.EstadoDAO;
import br.com.sorveteria.models.EstadoModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class EstadoController {

    public List<EstadoModel> getAll() {
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.getAll();
    }

    public List<EstadoModel> consultaPeloID(EstadoModel estadoModel) {
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.consultaPeloID(estadoModel);
    }

    public List<EstadoModel> consultaPeloNome(EstadoModel estadoModel) {
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.consultaPeloNome(estadoModel);
    }

    public List<EstadoModel> consultaPeloNomeIgual(EstadoModel estadoModel) {
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.consultaPeloNomeIgual(estadoModel);
    }

    public Boolean cadastra(EstadoModel estadoModel) {
        EstadoDAO estadoDAO = new EstadoDAO();
        List<EstadoModel> data = consultaPeloNomeIgual(estadoModel);
        if (data.size() <= 0) {
            estadoDAO.cadastra(estadoModel);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Já tem um estado cadastrado com esse nome!");
            return false;
        }
    }

    public Boolean atualiza(EstadoModel estadoModel) {
        EstadoDAO estadoDAO = new EstadoDAO();
        List<EstadoModel> data = consultaPeloID(estadoModel);
        if (data.size() > 0) {
            estadoDAO.atualiza(estadoModel);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Por favor verifique o estado que você está tentando atualizar!");
            return false;
        }
    }

    public Boolean atualizaStatus(EstadoModel estadoModel) {
        EstadoDAO estadoDAO = new EstadoDAO();
        List<EstadoModel> data = consultaPeloID(estadoModel);
        if (data.size() > 0) {
            estadoDAO.atualizaStatus(estadoModel);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Por favor verifique o estado que você está tentando atualizar!");
            return false;
        }
    }

}
