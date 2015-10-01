package br.com.sorveteria.controllers;

import br.com.sorveteria.dao.CabecalhoVendaDAO;
import br.com.sorveteria.models.CabecalhoVendaModel;
import java.util.List;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class CabecalhoVendaController {

    public void cadastra(CabecalhoVendaModel cabecalhoVendaModel) {
        CabecalhoVendaDAO cabecalhoVendaDAO = new CabecalhoVendaDAO();
        cabecalhoVendaDAO.cadastra(cabecalhoVendaModel);
    }

    public List<CabecalhoVendaModel> getVendasAbertas() {
        CabecalhoVendaDAO cabecalhoVendaDAO = new CabecalhoVendaDAO();
        return cabecalhoVendaDAO.getVendasAbertas();
    }
    
    public List<CabecalhoVendaModel> getAll() {
        CabecalhoVendaDAO cabecalhoVendaDAO = new CabecalhoVendaDAO();
        return cabecalhoVendaDAO.getAll();
    }

    public void finalizaVenda(CabecalhoVendaModel cvm) {
        CabecalhoVendaDAO cabecalhoVendaDAO = new CabecalhoVendaDAO();
        cabecalhoVendaDAO.finalizaVenda(cvm);
    }

}
