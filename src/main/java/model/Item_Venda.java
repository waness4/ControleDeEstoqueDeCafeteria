package model;

import java.io.Serializable;
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
    @JoinColumn(name="idProduto")
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name="idVenda")
    private Venda venda;
    
    @JoinColumn(name="qtProduto")
    private int qtProduto;
    
    @JoinColumn(name="desconto")
    private double desconto;

    public Item_Venda() {
    }
    
    public Item_Venda(int idItemVenda, Produto produto, Venda venda, int qtProduto, double desconto) {
        this.idItem_venda = idItemVenda;
        this.produto = produto;
        this.venda = venda;
        this.qtProduto = qtProduto;
        this.desconto = desconto;
    }

    public Item_Venda(Produto produto, Venda venda, int qtProduto, double desconto) {
        this.produto = produto;
        this.venda = venda;
        this.qtProduto = qtProduto;
        this.desconto = desconto;
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

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
