/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 *
 * @author wanes
 */
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipopessoa", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public abstract class Pessoa implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idPessoa;
    
    @Column (name="nomePessoa", nullable = false)    
    private String nome;
    
    @Column (name="emailPessoa", nullable = false)    
    private String email;
    
    @Column (unique = true, length = 11)
    private String celular;
    
 
    @OneToOne 
    @JoinColumn (name="idEndereco") 
    private Endereco endereco;

    public Pessoa() {
    }
    
    public Pessoa(
            String nome, 
            String email, 
            String celular, 
            String cep,
            String bairro,
            int numero,
            String complemento,
            String rua,
            String cidade, 
            String estado) {
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.endereco = new Endereco(cep, bairro, numero, complemento, rua, cidade, estado);
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
}
