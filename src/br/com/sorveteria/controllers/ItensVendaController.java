package br.com.sorveteria.controllers;

import br.com.sorveteria.dao.ItensVendaDAO;
import br.com.sorveteria.models.ItemVendaModel;
import java.util.List;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class ItensVendaController {

    public Double valorTotalVenda(Integer codigoVenda) {
        ItensVendaDAO itensVendaDAO = new ItensVendaDAO();
        return itensVendaDAO.valorTotalVenda(codigoVenda);
    }

    public List<ItemVendaModel> consultaPeloIdVenda(Integer codigoVenda) {
        ItensVendaDAO itensVendaDAO = new ItensVendaDAO();
        return itensVendaDAO.consultaPeloIdVenda(codigoVenda);
    }

    public void cadastraItensVenda(List<ItemVendaModel> itens) {
        ItensVendaDAO itensVendaDAO = new ItensVendaDAO();
        itensVendaDAO.cadastraItensVenda(itens);
    }

}
