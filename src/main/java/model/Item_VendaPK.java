/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author wanes
 */
@Entity
public class Item_VendaPK implements Serializable {
    
    @Id
    private int idItemVenda;
    
    @ManyToOne
    @JoinColumn(name="idProduto")
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name="idVenda")
    private Venda venda;
    
    @JoinColumn(name="qtPRoduto")
    private int qtProduto;
    
    @JoinColumn(name="desconto")
    private double desconto;

    public Item_VendaPK() {
    }

    public Item_VendaPK(Produto produto, Venda venda) {
        this.produto = produto;
        this.venda = venda;
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

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }
    
     
    
}
