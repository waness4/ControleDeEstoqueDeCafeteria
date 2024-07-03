/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.ConexaoHibernate;
import dao.GenericDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import model.Cliente;
import model.Fornecedor;
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
    
    /* CLIENTE */
    public List<Object> listarClientes(){
        return genDAO.listar(Cliente.class);
    }
    
    public Cliente inserirCliente(
            String cpf,
            String nome, 
            String email, 
            String celular, 
            String cep,
            String bairro,
            int numero,
            String complemento,
            String rua,
            String cidade, 
            String estado){
        
        Cliente cliente = new Cliente(cpf, nome, email, celular, cep, bairro, numero, complemento, rua, cidade, estado);
        genDAO.inserir(cliente);
        return cliente;
    }
    
    public List<Object> pesquisarCliente(String pesq)throws SQLException, ClassNotFoundException{
        return genDAO.listar(Cliente.class);        
    }
    
    /* FORNECEDOR */
    public List<Object> listarFornecedores(){
        return genDAO.listar(Fornecedor.class);
    }
    
    public Fornecedor inserirFornecedor(
            String cnpj,
            String nome, 
            String email, 
            String celular, 
            String cep,
            String bairro,
            int numero,
            String complemento,
            String rua,
            String cidade, 
            String estado){
        
        Fornecedor fornecedor = new Fornecedor(cnpj, nome, email, celular, cep, bairro, numero, complemento, rua, cidade, estado);
        genDAO.inserir(fornecedor);
        return fornecedor;
    }
    
    public List<Object> pesquisarFornecedor(String pesq)throws SQLException, ClassNotFoundException{
        return genDAO.listar(Fornecedor.class);        
    }
    
    /* PRODUTO*/
    public List<Object> listarProdutos(){
        return genDAO.listar(Produto.class);
    }
    
    public int inserirProduto(
            String nome, 
            double valor, 
            double tam_pes, 
            String unidMedida, 
            String categoria){
        
        Produto produto = new Produto(nome, valor, tam_pes, unidMedida, categoria);
        genDAO.inserir(produto);
        return produto.getIdProduto();
    }
    
    public List<Object> pesquisarProduto(String pesq)throws SQLException, ClassNotFoundException{
        return genDAO.listar(Produto.class);        
    }
    
    /* VENDA */
    public List<Object> listarVendas(){
        return genDAO.listar(Fornecedor.class);
    }   
    
    public Venda inserirVendas(
            Date dataVenda, 
            double totalVenda, 
            Date hora){
        
        Venda venda = new Venda(dataVenda, totalVenda, hora);
        genDAO.inserir(venda);
        return venda;
    }
    
    public List<Object> pesquisarVenda(String pesq)throws SQLException, ClassNotFoundException{
        return genDAO.listar(Venda.class);        
    }
}
