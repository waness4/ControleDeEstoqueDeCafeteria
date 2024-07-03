/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author wanes
 */
public class FornecedorAbstractTableModel extends AbstractTableModel{
    
    private List<Fornecedor> listaFornecedores = new ArrayList();
    
    @Override
    public int getRowCount() {
        return listaFornecedores.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Id", "Nome", "E-mail", "CNPJ", "Celular", "Cidade", "Estado"};        
        return nomesColunas[column];        
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fornecedor fornecedor = listaFornecedores.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> fornecedor.getIdPessoa();
            case 1 -> fornecedor.getNome();
            case 2 -> fornecedor.getEmail();
            case 3 -> fornecedor.getCnpj();
            case 4 -> fornecedor.getCelular();
            case 5 -> fornecedor.getEndereco().getCidade();
            case 6 -> fornecedor.getEndereco().getEstado();
            default -> null;
        };
    }
    
    public void adicionar (Fornecedor fornecedor){
        listaFornecedores.add(fornecedor);
        fireTableRowsInserted(listaFornecedores.size() -1, listaFornecedores.size() -1);
    }
    
    public void remover(int indice){
        listaFornecedores.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
    public Fornecedor getFornecedor(int linha) {
        return listaFornecedores.get(linha);
    }
    
    public void setLista(List<Fornecedor> novaLista) {
        
        if ( novaLista.isEmpty()) {
            if ( !listaFornecedores.isEmpty() ) {
                listaFornecedores.clear();
                fireTableRowsDeleted(0,0);
            }
        } else {
            listaFornecedores = novaLista;
            fireTableRowsInserted( 0, listaFornecedores.size() - 1);
        }     
    }
}
