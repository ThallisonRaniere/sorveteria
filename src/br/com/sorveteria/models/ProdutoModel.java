package br.com.sorveteria.models;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class ProdutoModel {


    private Integer idProduto;
    private String descricao;
    private Double saldoProduto;
    private Double precoVenda;
    private Double quantidade;
    private Double valorTotalProduto;
    private int status;

    public ProdutoModel() {
    }

    public Double getValorTotalProduto() {
        return valorTotalProduto;
    }

    public void setValorTotalProduto(Double valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSaldoProduto() {
        return saldoProduto;
    }

    public void setSaldoProduto(Double saldoProduto) {
        this.saldoProduto = saldoProduto;
    }

    public Double getPrecoVendaProduto() {
        return precoVenda;
    }

    public void setPrecoVendaProduto(Double precoVendaProduto) {
        this.precoVenda = precoVendaProduto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

}
