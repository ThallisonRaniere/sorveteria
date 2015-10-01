package br.com.sorveteria.models;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class ClienteModel extends CidadeModel {

    private Integer idCliente;
    private String cpfCliente;
    private String cnpjCliente;
    private String nomeCliente;
    private String contatoCliente;
    private String emailCliente;
    private String cepCliente;
    private Integer numeroLogradouroCliente;
    private int status;

    public ClienteModel() {

    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getCnpjCliente() {
        return cnpjCliente;
    }

    public void setCnpjCliente(String cnpjCliente) {
        this.cnpjCliente = cnpjCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getContatoCliente() {
        return contatoCliente;
    }

    public void setContatoCliente(String contatoCliente) {
        this.contatoCliente = contatoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public Integer getNumeroLogradouroCliente() {
        return numeroLogradouroCliente;
    }

    public void setNumeroLogradouroCliente(Integer numeroLogradouroCliente) {
        this.numeroLogradouroCliente = numeroLogradouroCliente;
    }

}
