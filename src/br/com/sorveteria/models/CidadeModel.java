package br.com.sorveteria.models;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class CidadeModel extends EstadoModel {

    private Integer idCidade;
    private String nomeCidade;

    public CidadeModel() {
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
}
