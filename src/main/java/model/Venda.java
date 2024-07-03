/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author wanes
 */
@Entity
public class Venda implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idVenda;
    
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    
    @Column (name="totalVenda", nullable = false)
    private double totalVenda;
    
    @ManyToOne
    @JoinColumn(name="idCliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="idItemVenda")
    private Item_VendaPK itemVenda;
    
    @ManyToOne
    @JoinColumn(name="idFormaPagamento")
    private FormaPagamento formaPagameto;
    
    @Temporal(TemporalType.TIME)
    private Date hora;

    public Venda() {
    }

    public Venda(Date dataVenda, 
            double totalVenda, 
            Date hora) {
        this.dataVenda = dataVenda;
        this.totalVenda = totalVenda;
        this.hora = hora;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
    
    
}
