package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Item_Venda;
import model.Produto;

/**
 *
 * @author wanes
 */
public class VendaAbstractTableModel extends AbstractTableModel {
    
    private List<Item_Venda> listaItens = new ArrayList<>();

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
        String nomesColunas[] = {"Produto", "Quantidade", "Preço", "Total"};
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item_Venda itemVenda = listaItens.get(rowIndex);
        Produto produto = itemVenda.getProduto();
        return switch (columnIndex) {
            case 0 -> produto.getNome();
            case 1 -> itemVenda.getQtProduto();
            case 2 -> produto.getValor();
            case 3 -> itemVenda.getQtProduto() * produto.getValor();
            default -> null;
        };
    }

    public void adicionar(Produto produto, int quantidade) {
        for (Item_Venda iv : listaItens) {
            if (iv.getProduto().getIdProduto() == produto.getIdProduto()) {
                iv.setQtProduto(iv.getQtProduto() + quantidade);
                fireTableDataChanged();
                return;
            }
        }
        listaItens.add(new Item_Venda(produto, null, quantidade));
        fireTableRowsInserted(listaItens.size() - 1, listaItens.size() - 1);
    }

    public void remover(int indice) {
        listaItens.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public Item_Venda getItemVenda(int linha) {
        return listaItens.get(linha);
    }

    public void setLista(List<Item_Venda> novaLista) {
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

    public List<Item_Venda> getListaItens() {
        return listaItens;
    }
    
    public void limpar() {
        listaItens.clear();
        fireTableDataChanged();
    }
    
    public void adicionarItem(Item_Venda itemVenda) {
        listaItens.add(itemVenda);
        fireTableDataChanged();
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Item_Venda item : listaItens) {
            total += item.getQtProduto() * item.getProduto().getValor();
        }
        return total;
    }
}