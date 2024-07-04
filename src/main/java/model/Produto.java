package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "produto")
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
    
    @Column (name="estoque", nullable = false)
    private double estoque;
    
    @OneToMany(mappedBy = "produto")
    private List<Item_Venda> item_venda;

    public Produto() {
    }
    
    

    public Produto(String nome, 
            double valor, 
            double tam_pes, 
            String unidMedida, 
            String categoria, 
            double estoque){
        
        this.nome = nome;
        this.valor = valor;
        this.tam_pes = tam_pes;
        this.unidMedida = unidMedida;
        this.categoria = categoria;
        this.estoque = this.estoque;
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

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public Item_Venda getItem_venda() {
        return (Item_Venda) item_venda;
    }

    public void setItem_venda(Item_Venda item_venda) {
        this.item_venda = (List<Item_Venda>) item_venda;
    }
    
    public int getQuantidadeTotalVendida() {
        int quantidadeTotal = 0;
        if (item_venda != null) {
            for (Item_Venda item : item_venda) {
                quantidadeTotal += item.getQtProduto();
            }
        }
        return quantidadeTotal;
    }
}
