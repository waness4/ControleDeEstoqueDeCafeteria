package control;

import dao.ConexaoHibernate;
import dao.GenericDAO;
import java.sql.SQLException;
import java.util.List;
import model.Cliente;
import model.Item_Venda;
import model.Produto;
import model.Venda;


/**
 *
 * @author wanes
 */
public class GerenciadorDeDominio {
    
    private GenericDAO genDAO; 
    
    public GerenciadorDeDominio() throws ClassNotFoundException{
        ConexaoHibernate.getSessionFactory();
        this.genDAO = new GenericDAO();
        if (this.genDAO == null) {
            throw new RuntimeException("genDAO não foi inicializado corretamente.");
        }
    }
    
    public List listar(Class classe) throws ClassNotFoundException, SQLException {
        return genDAO.listar(classe );
    }
    
    
    /* CLIENTE */
    
    public Cliente inserirCliente(
            String nome,
            String cpf, 
            String tel){
        
        Cliente cliente = new Cliente(nome, cpf, tel);
        genDAO.inserir(cliente);
        return cliente;
    }
    
    public List<Object> pesquisarCliente(String pesq)throws SQLException, ClassNotFoundException{
        return genDAO.listar(Cliente.class);        
    }
   
    
    /* PRODUTO*/
    
    public Produto inserirProduto(
            String nome, 
            double valor, 
            double tam_pes, 
            String unidMedida, 
            String categoria,
            double estoque){
        
        Produto produto = new Produto(nome, valor, tam_pes, unidMedida, categoria, estoque);
        genDAO.inserir(produto);
        return produto;
    }
    
    public List<Object> pesquisarProduto(String pesq)throws SQLException, ClassNotFoundException{
        return genDAO.listar(Produto.class);        
    }
    
    /* VENDA */  
    
    public Venda inserirVendas(
            double totalVenda, 
            Cliente cliente){
        
        Venda venda = new Venda(totalVenda, cliente);
        genDAO.inserir(venda);
        return venda;
    }
    
    public List<Object> pesquisarVenda(String pesq)throws SQLException, ClassNotFoundException{
        return genDAO.listar(Venda.class);        
    }
    
    /* ITEM VENDA */
    public Item_Venda inserirItemVenda(Produto produto, Venda venda, int quantidade, double preco, double desconto) {
        Item_Venda itemVenda = new Item_Venda(quantidade, produto, venda, quantidade, desconto);
        genDAO.inserir(itemVenda);
        return itemVenda;
    }
    
    public List<Object> pesquisarItemVenda(String pesq) throws SQLException, ClassNotFoundException {
        return genDAO.listar(Item_Venda.class);        
    }
}
