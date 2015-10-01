package br.com.sorveteria.controllers;

import br.com.sorveteria.dao.UsuarioDAO;
import br.com.sorveteria.models.UsuarioModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class UsuarioController {

    public List<UsuarioModel> consultaPeloID(UsuarioModel usuarioModel) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.consultaPeloID(usuarioModel);
    }

    public String consultaNomePeloID(Integer id) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.consultaNomeUsuario(id);
    }

    public List<UsuarioModel> consultaPeloNome(UsuarioModel usuarioModel) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.consultaPeloNome(usuarioModel);
    }

    public List<UsuarioModel> consultaPeloNomeIgual(UsuarioModel usuarioModel) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.consultaPeloNomeIgual(usuarioModel);
    }

    public Boolean cadastra(UsuarioModel usuarioModel) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<UsuarioModel> data = consultaPeloNomeIgual(usuarioModel);
        if (data.size() <= 0) {
            usuarioDAO.cadastra(usuarioModel);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Já existe um usuário cadastrado com esse nome!");
            return false;
        }
    }

    public Boolean atualiza(UsuarioModel usuarioModel) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<UsuarioModel> data = consultaPeloID(usuarioModel);
        if (data.size() > 0) {
            usuarioDAO.atualiza(usuarioModel);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Por favor verifique o usuário que você está tentando atualizar!");
            return false;
        }
    }

    public Boolean verificaLogin(String login, int cod) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.buscaLogin(login, cod);
    }

    public Boolean validaLoginUsuario(UsuarioModel usuarioModel) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.validaLoginUsuario(usuarioModel);
    }
}
