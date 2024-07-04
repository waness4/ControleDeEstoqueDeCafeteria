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
        return 4;
    }
    
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Id", "Nome", "CPF", "Telefone"};        
        return nomesColunas[column];        
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = listaClientes.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> cliente.getIdCliente();
            case 1 -> cliente.getNome();
            case 2 -> cliente.getCpf();
            case 3 -> cliente.getTel();
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