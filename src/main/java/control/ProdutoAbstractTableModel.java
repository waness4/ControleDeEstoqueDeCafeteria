package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Produto;

/**
 *
 * @author wanes
 */
public class ProdutoAbstractTableModel extends AbstractTableModel{
    private List<Produto> listaItens = new ArrayList();
    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Id", "Nome", "Categoria", "Tam/Pes", "UnidMedica", "Valor", "Estoque"};        
        return nomesColunas[column];        
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto item = listaItens.get(rowIndex);
        switch (columnIndex){
            case 0: return item.getIdProduto();
            case 1: return item.getNome();
            case 2: return item.getCategoria();
            case 3: return item.getTam_pes();
            case 4: return item.getUnidMedida();
            case 5: return item.getValor();
            case 6: return item.getEstoque();
            default: return null;
        }
        //return null;
    }
    
    public void adicionar (Produto item) {
        listaItens.add(item);
        fireTableRowsInserted( listaItens.size() - 1, listaItens.size() - 1 );
        
    }
    
    public void remover (int indice) {        
        listaItens.remove(indice);
        fireTableRowsDeleted( indice, indice );   
    }
    
    public Produto getProduto(int linha) {
        return listaItens.get(linha);
    }
    
    public void setLista(List<Produto> novaLista) {
        
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
