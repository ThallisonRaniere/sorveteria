package br.com.sorveteria.controllers;

import br.com.sorveteria.dao.ProdutoDAO;
import br.com.sorveteria.models.ProdutoModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class ProdutoController {

    public List<ProdutoModel> consultaPeloID(ProdutoModel produtoModel) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.consultaPeloID(produtoModel);
    }

    public List<ProdutoModel> consultaPeloNome(ProdutoModel produtoModel) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.consultaPeloNome(produtoModel);
    }

    public List<ProdutoModel> consultaPeloNomeIgual(ProdutoModel produtoModel) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.consultaPeloNomeIgual(produtoModel);
    }

    public Boolean cadastra(ProdutoModel produtoModel) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<ProdutoModel> data = consultaPeloNomeIgual(produtoModel);
        if (data.size() <= 0) {
            produtoDAO.cadastra(produtoModel);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Já tem esse produto cadastrado no sistema!");
            return false;
        }
    }

    public Boolean atualiza(ProdutoModel produtoModel) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<ProdutoModel> data = consultaPeloID(produtoModel);
        if (data.size() > 0) {
            produtoDAO.atualiza(produtoModel);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar o produto, verifique o mesmo por favor!");
            return false;
        }
    }

    public void entradaestoque(ProdutoModel produtoModel) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.entrada(produtoModel);
    }

    public void saidaestoque(ProdutoModel produtoModel) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.saida(produtoModel);
    }

}
