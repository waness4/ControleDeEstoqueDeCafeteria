package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author wanes
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idVenda;
    
    @Column (name="totalVenda", nullable = false)
    private double totalVenda;
    
    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;
    
    @OneToMany(mappedBy = "venda")
    private List<Item_Venda> item_venda;

    public Venda() {
    }

    public Venda(
            double totalVenda, Cliente cliente) {
        this.totalVenda = totalVenda;
        this.cliente = cliente;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }        

    public List<Item_Venda> getItem_venda() {
        return item_venda;
    }

    public void setItem_venda(List<Item_Venda> item_venda) {
        this.item_venda = item_venda;
    }   
    
}
