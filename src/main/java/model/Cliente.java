package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author wanes
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idCliente;
    
    @Column (name="nomeCliente", nullable = false)    
    private String nome;
    
    @Column (name= "cpf", unique = true, length = 15)
    private String cpf;
    
    @Column (name= "tel", unique = true, length = 15)
    private String tel;
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venda> vendas;

    public Cliente(int idCliente, String nome, String cpf, String tel) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
    }

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String tel) {
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Venda> getVenda() {
        return vendas;
    }

    public void setVenda(List<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public String toString() {
        return this.getNome() + " - " + this.getCpf();
    }
    
    
}
