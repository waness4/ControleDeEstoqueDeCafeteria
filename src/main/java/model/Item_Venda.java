package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author wanes
 */

@Entity
@Table(name = "item_venda")
public class Item_Venda implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItem_venda;
    
     @ManyToOne
    @JoinColumn(name = "idProduto", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "idVenda", nullable = false)
    private Venda venda;

    @Column(name = "qtProduto", nullable = false)
    private int qtProduto;

    public Item_Venda() {
    }
    
    public Item_Venda(int idItemVenda, Produto produto, Venda venda, int qtProduto) {
        this.idItem_venda = idItemVenda;
        this.produto = produto;
        this.venda = venda;
        this.qtProduto = qtProduto;
    }

    public Item_Venda(Produto produto, Venda venda, int qtProduto) {
        this.produto = produto;
        this.venda = venda;
        this.qtProduto = qtProduto;
    }
    
    public int getIdItem_venda() {
        return idItem_venda;
    }

    public void setIdItem_venda(int idItem_venda) {
        this.idItem_venda = idItem_venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getQtProduto() {
        return qtProduto;
    }

    public void setQtProduto(int qtProduto) {
        this.qtProduto = qtProduto;
    }    
}
