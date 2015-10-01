package br.com.sorveteria.models;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class EstadoModel {

    private Integer idEstado = 0;
    private String siglaEstado;
    private int status;

    public EstadoModel() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

}
