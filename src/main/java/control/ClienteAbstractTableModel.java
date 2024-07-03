/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author wanes
 */
public class ClienteAbstractTableModel extends AbstractTableModel{
    
    private List<Cliente> listaClientes = new ArrayList();
    
    @Override
    public int getRowCount() {
        return listaClientes.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Id", "Nome", "E-mail", "CPF", "Celular", "Cidade", "Estado"};        
        return nomesColunas[column];        
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = listaClientes.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> cliente.getIdPessoa();
            case 1 -> cliente.getNome();
            case 2 -> cliente.getEmail();
            case 3 -> cliente.getCpf();
            case 4 -> cliente.getCelular();
            case 5 -> cliente.getEndereco().getCidade();
            case 6 -> cliente.getEndereco().getEstado();
            default -> null;
        };
    }
    
    public void adicionar (Cliente cliente){
        listaClientes.add(cliente);
        fireTableRowsInserted(listaClientes.size() -1, listaClientes.size() -1);
    }
    
    public void remover(int indice){
        listaClientes.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
    public Cliente getCliente(int linha) {
        return listaClientes.get(linha);
    }
    
    public void setLista(List<Cliente> novaLista) {
        
        if ( novaLista.isEmpty()) {
            if ( !listaClientes.isEmpty() ) {
                listaClientes.clear();
                fireTableRowsDeleted(0,0);
            }
        } else {
            listaClientes = novaLista;
            fireTableRowsInserted( 0, listaClientes.size() - 1);
        }     
    }
}