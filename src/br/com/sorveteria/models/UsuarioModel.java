package br.com.sorveteria.models;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class UsuarioModel extends CidadeModel {

    public Integer usuarioLogado;
    private Integer idUsuario;
    private String nomeUsuario;
    private String cpfUsuario;
    private String cepUsuario;
    private Integer numeroLogradouroUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private int status;

    public UsuarioModel() {
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getCepUsuario() {
        return cepUsuario;
    }

    public void setCepUsuario(String cepUsuario) {
        this.cepUsuario = cepUsuario;
    }

    public Integer getNumeroLogradouroUsuario() {
        return numeroLogradouroUsuario;
    }

    public void setNumeroLogradouroUsuario(Integer numeroLogradouroUsuario) {
        this.numeroLogradouroUsuario = numeroLogradouroUsuario;
    }

}
