package control;

import dao.ConexaoHibernate;
import dao.GenericDAO;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
    private List<Item_Venda> itensVendaTemp;
    
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
    
    public boolean clienteTemReferencias(Cliente cliente) throws ClassNotFoundException, SQLException {
        List<Venda> vendas = listar(Venda.class);
        for (Venda venda : vendas) {
            if (venda.getCliente().getIdCliente() == cliente.getIdCliente()) {
                return true;
            }
        }
        return false;
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
    
    public void adicionarQuantidadeProduto(
            Produto produto, 
            int estoque){
        produto.adicionarQuantidadeEstoque(estoque);
        genDAO.alterar(produto);
    }
    
    public void retirarQuantidadeProduto(Produto produto, int quantidade) {
        produto.retirarQuantidadeEstoque(quantidade);
        genDAO.alterar(produto);
    }

    public void atualizarProduto(Produto produto) {
        genDAO.alterar(produto);
    }
    
    public void excluirProduto(Produto produto){
        genDAO.excluir(produto);
    }
    
    /* VENDA */  
    
    public Venda inserirVenda(double totalVenda, Cliente cliente) {
        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setTotalVenda(totalVenda);
        venda.setDataVenda(new Timestamp(new Date().getTime()));
        genDAO.inserir(venda);
        return venda;
    }

    public List<Object> pesquisarVenda(String pesq, int tipo) throws SQLException, ClassNotFoundException {
        switch(tipo){
            case 0: return genDAO.pesquisar(Venda.class, Restrictions.eq("idVenda", pesq));
            case 1: return genDAO.pesquisar(Venda.class, Restrictions.eq("idCliente", pesq));    
            case 2: return genDAO.pesquisar(Venda.class, Restrictions.eq("dataVenda", pesq));
            default: return null;
        }
    }
    
    /* ITEM VENDA */
    public void adicionarItemVendaTemp(Produto produto, int quantidade) {
        if (itensVendaTemp == null) {
            itensVendaTemp = new ArrayList<>();
        }

        boolean itemEncontrado = false;
        for (Item_Venda item : itensVendaTemp) {
            if (item.getProduto().getIdProduto() == produto.getIdProduto()) {
                item.setQtProduto(item.getQtProduto() + quantidade);
                itemEncontrado = true;
                break;
            }
        }

        if (!itemEncontrado) {
            Item_Venda itemVenda = new Item_Venda(produto, null, quantidade);
            itensVendaTemp.add(itemVenda);
        }
    }
    
    public void adicionarItemVenda(Item_Venda itemVenda) {
        genDAO.inserir(itemVenda);
    }

    public List<Item_Venda> getItensVendaTemp() {
        return itensVendaTemp;
    }
}
