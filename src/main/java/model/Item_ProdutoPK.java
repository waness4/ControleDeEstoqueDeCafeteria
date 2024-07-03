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
public class Item_ProdutoPK implements Serializable {
    
    @Id
    private int idItemProduto;
    
    @ManyToOne
    @JoinColumn(name="idFornecedor")
    private Fornecedor fornecedor;
    
    @ManyToOne
    @JoinColumn(name="idProduto")
    private Produto produto;
    
    private int qtMinima;
    private int qtMaxima;

    public Item_ProdutoPK() {
    }
    
    public Item_ProdutoPK(Fornecedor fornecedor, Produto produto) {
        this.fornecedor = fornecedor;
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getIdItemProduto() {
        return idItemProduto;
    }

    public void setIdItemProduto(int idItemProduto) {
        this.idItemProduto = idItemProduto;
    }
    
    
}
