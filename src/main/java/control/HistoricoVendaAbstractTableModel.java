package control;

import java.util.ArrayList;
import java.util.List;
import model.Venda;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author wanes
 */
public class HistoricoVendaAbstractTableModel  extends AbstractTableModel{
    
    private List<Venda> listaItens = new ArrayList<>();
    
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
        String nomesColunas[] = {"Id Venda", "Cliente", "Data-Hora", "Total"};        
        return nomesColunas[column];        
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venda venda = listaItens.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> venda.getIdVenda();
            case 1 -> venda.getCliente().getNome();
            case 2 -> venda.getDataVenda();
            case 3 -> venda.getTotalVenda();
            default -> null;
        };
    }
    
    public void adicionar(Venda venda){
        listaItens.add(venda);
        fireTableRowsInserted(listaItens.size() - 1, listaItens.size() - 1);
    }
    
    public void remover(int indice){
        listaItens.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
    public Venda getVenda(int linha) {
        return listaItens.get(linha);
    }
    
    public void setLista(List<Venda> novaLista) {
        if (novaLista.isEmpty()) {
            if (!listaItens.isEmpty()) {
                listaItens.clear();
                fireTableRowsDeleted(0, 0);
            }
        } else {
            listaItens = novaLista;
            fireTableRowsInserted(0, listaItens.size() - 1);
        }     
    }   
    
}
