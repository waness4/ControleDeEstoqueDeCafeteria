/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author wanes
 */
@Entity
public class FormaPagamento implements Serializable {

    @Id
    private int idFormaPagamento;
    
    @Column (name="formaPagamento", nullable = false) 
    private String formaPagamento;

    public FormaPagamento() {
    }

    public FormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    
}
