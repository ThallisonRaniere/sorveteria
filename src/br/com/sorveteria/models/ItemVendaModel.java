package br.com.sorveteria.models;


/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class ItemVendaModel extends ProdutoModel {

    private Integer idItemVenda;
    private Integer item;
    private Integer idVenda;
    private Double valorTotalItem;

    public ItemVendaModel(){
        
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }
    
    public Integer getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(Integer idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Double getValorTotalItem() {
        return valorTotalItem;
    }

    public void setValorTotalItem(Double valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }

}
