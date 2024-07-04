package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Venda;

/**
 *
 * @author wanes
 */
public class VendaAbstractTableModel extends AbstractTableModel{
    
    private List<Venda> listaItens = new ArrayList();
    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Id", "Nome", "Categoria", "Tam/Pes", "UnidMedica", "Valor"};        
        return nomesColunas[column];        
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venda item = listaItens.get(rowIndex);
        switch (columnIndex){
            case 0: return item.getItemVenda().getProduto().getNome();
            case 1: return item.getItemVenda().getProduto().getCategoria();
            case 2: return item.getItemVenda().getProduto().getValor();
            case 3: return item.getItemVenda().getQtProduto();
            default: return null;
        }
        //return null;
    }
    
    public void adicionar (Venda item) {
        listaItens.add(item);
        fireTableRowsInserted( listaItens.size() - 1, listaItens.size() - 1 );
        
    }
    
    public void remover (int indice) {        
        listaItens.remove(indice);
        fireTableRowsDeleted( indice, indice );   
    }
    
    public Venda getProduto(int linha) {
        return listaItens.get(linha);
    }
    
    public void setLista(List<Venda> novaLista) {
        
        if ( novaLista.isEmpty()) {
            if ( !listaItens.isEmpty() ) {
                listaItens.clear();
                fireTableRowsDeleted(0,0);
            }
        } else {
            listaItens = novaLista;
            fireTableRowsInserted( 0, listaItens.size() - 1);
        }     
    }
}
