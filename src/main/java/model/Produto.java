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
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idProduto;
    
    @Column (name="nomeProduto", nullable = false)   
    private String nome;
    
    @Column (name="valor", nullable = false)
    private double valor;
    
    @Column (name="tam_pes", nullable = false)
    private double tam_pes;
    
    @Column (name="unidMedica", nullable = false)   
    private String unidMedida;
    
    @Column (name="categoria", nullable = false)   
    private String categoria;

    public Produto() {
    }

    public Produto(String nome, 
            double valor, 
            double tam_pes, 
            String unidMedida, 
            String categoria){
        this.nome = nome;
        this.valor = valor;
        this.tam_pes = tam_pes;
        this.unidMedida = unidMedida;
        this.categoria = categoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTam_pes() {
        return tam_pes;
    }

    public void setTam_pes(double tam_pes) {
        this.tam_pes = tam_pes;
    }

    public String getUnidMedida() {
        return unidMedida;
    }

    public void setUnidMedida(String unidMedida) {
        this.unidMedida = unidMedida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
