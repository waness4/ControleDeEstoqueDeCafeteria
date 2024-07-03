/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author wanes
 */
@Entity
public class Endereco implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idEndereco;
    
    @Column (name="cep", length = 8) 
    private String cep;
    
    @Column (name="bairro", nullable = false) 
    private String bairro;
    
    @Column (name="numero", nullable = false)
    private int numero;
    
    @Column (name="complemento", nullable = false) 
    private String complemento;
    
    @Column (name="rua", nullable = false) 
    private String rua;
    
    @Column (name="cidade", nullable = false) 
    private String cidade;
    
    @Column (name="estado", nullable = false) 
    private String estado;

    public Endereco() {
    }
        
    public Endereco(String cep, String bairro, int numero, String complemento, String rua, String cidade, String estado) {
        this.cep = cep;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
