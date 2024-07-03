/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author wanes
 */
@Entity
@DiscriminatorValue("1")
public class Fornecedor extends Pessoa  implements Serializable{
    
    @Column (unique = true, length = 17)
    private String cnpj;

    public Fornecedor() {
    }

    
    public Fornecedor(String cnpj, String nome, String email, String celular, String cep, String bairro, int numero, String complemento, String rua, String cidade, String estado) {
        super(nome, email, celular, cep, bairro, numero, complemento, rua, cidade, estado);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
