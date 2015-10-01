package br.com.sorveteria.controllers;

import br.com.sorveteria.dao.CidadeDAO;
import br.com.sorveteria.models.CidadeModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class CidadeController {

    public List<CidadeModel> consultaPeloID(CidadeModel cidadeModel) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.consultaPeloID(cidadeModel);
    }

    public List<CidadeModel> getCidadesEstado(CidadeModel cidadeModel) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.getCidadesEstado(cidadeModel);
    }

    public List<CidadeModel> consultaPeloIDEstado(Integer cod) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.consultaPeloIdEstado(cod);
    }

    public List<CidadeModel> consultaPeloNome(CidadeModel cidadeModel) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.consultaPeloNome(cidadeModel);
    }

    public List<CidadeModel> consultaPeloNomeAndEstado(CidadeModel cidadeModel) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.consultaPeloNomeAndEstado(cidadeModel);
    }

    public Boolean cadastra(CidadeModel cidadeModel) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        List<CidadeModel> data = consultaPeloNomeAndEstado(cidadeModel);
        if (data.size() <= 0) {
            cidadeDAO.cadastra(cidadeModel);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Já tem uma cidade cadastrada com esse nome nesse estado!");
            return false;
        }
    }

    public Boolean atualiza(CidadeModel cidadeModel) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        List<CidadeModel> data = consultaPeloID(cidadeModel);
        if (data.size() > 0) {
            cidadeDAO.atualiza(cidadeModel);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Por favor verifique a cidade que você está tentando atualizar!");
            return false;
        }
    }

    public Boolean atualizarStatus(CidadeModel cidadeModel) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        List<CidadeModel> data = consultaPeloID(cidadeModel);
        if (data.size() > 0) {
            cidadeDAO.atualizarStatus(cidadeModel);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Por favor verifique a cidade que você está tentando atualizar!");
            return false;
        }
    }

}
