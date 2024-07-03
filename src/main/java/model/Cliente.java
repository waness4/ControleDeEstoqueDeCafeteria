/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author wanes
 */
@Entity
@DiscriminatorValue("2")
public class Cliente extends Pessoa implements Serializable{
    
    @Column (unique = true, length = 14)
    private String cpf;
    
    @ManyToOne
    @JoinColumn(name="idVenda")
    private Venda venda;

    public Cliente() {
    }
    
    public Cliente(String cpf, String nome, String email, String celular, String cep, String bairro, int numero, String complemento, String rua, String cidade, String estado) {
        super(nome, email, celular, cep, bairro, numero, complemento, rua, cidade, estado);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
