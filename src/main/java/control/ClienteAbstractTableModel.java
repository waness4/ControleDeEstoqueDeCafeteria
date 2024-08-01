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
    
    private List<Cliente> listaItens = new ArrayList();
    
    @Override
    public int getRowCount() {
        return listaItens.size();
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
        Cliente cliente = listaItens.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> cliente.getIdCliente();
            case 1 -> cliente.getNome();
            case 2 -> cliente.getCpf();
            case 3 -> cliente.getTel();
            default -> null;
        };
    }
    
    public void adicionar (Cliente cliente){
        listaItens.add(cliente);
        fireTableRowsInserted(listaItens.size() -1, listaItens.size() -1);
    }
    
    public void remover(int indice){
        listaItens.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
    public Cliente getCliente(int linha) {
        return listaItens.get(linha);
    }
    
    public void setLista(List<Cliente> novaLista) {
        
        if ( novaLista.isEmpty()) {
            if ( !listaItens.isEmpty() ) {
                listaItens.clear();
                fireTableRowsDeleted(0,0);
            }
        } else {
            listaItens = novaLista;
            fireTableRowsInserted(0, listaItens.size() - 1);
        }     
    }
}