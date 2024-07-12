package control;

import dao.ConexaoHibernate;
import dao.GenericDAO;
import java.sql.SQLException;
import java.util.List;
import model.Cliente;
import model.Item_Venda;
import model.Produto;
import model.Venda;
import org.hibernate.criterion.Restrictions;


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
    
    public List<Object> pesquisarCliente(String pesq, int tipo)throws SQLException, ClassNotFoundException{
        switch(tipo){
            case 0: return genDAO.pesquisar(Cliente.class, Restrictions.eq("idCliente", pesq));
            case 1: return genDAO.pesquisar(Cliente.class, Restrictions.eq("nome", pesq));
            case 2: return genDAO.pesquisar(Cliente.class, Restrictions.eq("cpf", pesq));
            case 3: return genDAO.pesquisar(Cliente.class, Restrictions.eq("tel", pesq));
            default: return null;
        }        
    }
    
    public void alterarCliente(
            Cliente cliente,
            String nome,
            String cpf, 
            String tel){
        
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setTel(tel);
        genDAO.alterar(cliente);
    }
    
    public void excluirCliente(Cliente cliente){
        genDAO.excluir(cliente);
    }
   
    
    /* PRODUTO*/
    
    public Produto inserirProduto(
            String nome, 
            double valor, 
            double tam_pes, 
            String unidMedida, 
            String categoria,
            int estoque){
        
        Produto produto = new Produto(nome, valor, tam_pes, unidMedida, categoria, estoque);
        genDAO.inserir(produto);
        return produto;
    }
    
    public List<Object> pesquisarProduto(String pesq, int tipo)throws SQLException, ClassNotFoundException{
        switch(tipo){
            case 0: return genDAO.pesquisar(Produto.class, Restrictions.eq("idProduto", pesq));
            case 1: return genDAO.pesquisar(Produto.class, Restrictions.eq("nome", pesq));    
            case 2: return genDAO.pesquisar(Produto.class, Restrictions.eq("valor", pesq));
            case 3: return genDAO.pesquisar(Produto.class, Restrictions.eq("tam_pes", pesq));    
            case 4: return genDAO.pesquisar(Produto.class, Restrictions.eq("unidMedida", pesq));
            case 5: return genDAO.pesquisar(Produto.class, Restrictions.eq("categoria", pesq));
            case 6: return genDAO.pesquisar(Produto.class, Restrictions.eq("estoque", pesq));
            default: return null;
        }      
    }
    
    public void alterarProduto(
            Produto produto,
            String nome, 
            double valor, 
            double tam_pes, 
            String unidMedida, 
            String categoria,
            int estoque){
        
        produto.setCategoria(categoria);
        produto.setEstoque(estoque);
        produto.setNome(nome);
        produto.setTam_pes(tam_pes);
        produto.setUnidMedida(unidMedida);
        produto.setValor(valor);
        
        genDAO.alterar(produto);
    }
    
    public void alterarQuantidadeProduto(
            Produto produto, 
            int estoque){
        produto.alterarQuantidadeEstoque(estoque);
        genDAO.alterar(produto);
    }
    
    public void excluirProduto(Produto produto){
        genDAO.excluir(produto);
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
