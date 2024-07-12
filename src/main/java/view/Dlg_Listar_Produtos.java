package view;

import control.GerenciadorDeInterface;
import control.ProdutoAbstractTableModel;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import model.Produto;
import org.hibernate.HibernateException;

/**
 *
 * @author wanes
 */
public class Dlg_Listar_Produtos extends javax.swing.JDialog {

    
    private GerenciadorDeInterface inter; 
    private ProdutoAbstractTableModel proTableModel;
    private Produto proSelecionado = null;
    
    public Dlg_Listar_Produtos(java.awt.Frame parent, boolean modal, GerenciadorDeInterface inter) {
        super(parent, modal);
        initComponents();
        this.inter = inter;
        proTableModel = new ProdutoAbstractTableModel();
        tbListarProduto.setModel((TableModel) proTableModel);
        atualizarTabelaProduto();
        setFalseButton();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btVoltarListarProduto = new javax.swing.JButton();
        fieldListarProdutos = new javax.swing.JTextField();
        btPesquisarConsultarCliente = new javax.swing.JButton();
        scrolConsultarCliente = new javax.swing.JScrollPane();
        tbListarProduto = new javax.swing.JTable();
        btSelecionarProduto = new javax.swing.JButton();
        btExcluirProduto = new javax.swing.JButton();
        btCancelarProduto = new javax.swing.JButton();
        btAlterarProduto = new javax.swing.JButton();
        labFundoListaProduto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel1.setText("LISTA PRODUTOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        btVoltarListarProduto.setText("Voltar");
        btVoltarListarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarListarProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltarListarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 70, 30));
        getContentPane().add(fieldListarProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 220, 30));

        btPesquisarConsultarCliente.setText("Buscar");
        btPesquisarConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarConsultarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btPesquisarConsultarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 80, 30));

        tbListarProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Categoria", "Medida", "Tam/Pes", "Preço Unid", "Estoque"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbListarProduto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbListarProduto.setShowHorizontalLines(true);
        scrolConsultarCliente.setViewportView(tbListarProduto);

        getContentPane().add(scrolConsultarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 540, 180));

        btSelecionarProduto.setText("Selecionar");
        btSelecionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btSelecionarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 110, 30));

        btExcluirProduto.setText("Excluir");
        btExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btExcluirProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 110, 30));

        btCancelarProduto.setText("Cancelar");
        btCancelarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btCancelarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 110, 30));

        btAlterarProduto.setText("Alterar");
        btAlterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btAlterarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 110, 30));

        labFundoListaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagem-fundo-2.png"))); // NOI18N
        getContentPane().add(labFundoListaProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSelecionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarProdutoActionPerformed
        int selectedRow = tbListarProduto.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um produto.", "ERRO: Selecionar Produto", JOptionPane.ERROR_MESSAGE);
        } else {
            setTrueButton();
        }
    }//GEN-LAST:event_btSelecionarProdutoActionPerformed

    private void btVoltarListarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarListarProdutoActionPerformed
        this.setVisible(false);
        try {
            inter.abrirJanelaDlg_Menu();
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btVoltarListarProdutoActionPerformed

    private void btExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirProdutoActionPerformed
    
        int selectedRow = tbListarProduto.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um produto.", "ERRO: Excluir Produto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Produto produto = proTableModel.getProduto(selectedRow);
        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o produto " + produto.getNome() + "?", "Excluir Produto", JOptionPane.YES_NO_OPTION);
    
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                GerenciadorDeInterface.getInstance().getDominio().excluirProduto(produto);
                atualizarTabelaProduto();
                JOptionPane.showMessageDialog(this, "Produto excluído com sucesso.", "Excluir Produto", JOptionPane.INFORMATION_MESSAGE);
                setFalseButton();
            } catch (HibernateException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir produto: " + ex.getMessage(), "ERRO: Excluir Produto", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_btExcluirProdutoActionPerformed

    private void btCancelarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarProdutoActionPerformed
        setFalseButton();
    }//GEN-LAST:event_btCancelarProdutoActionPerformed

    private void btAlterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarProdutoActionPerformed
    
        int selectedRow = tbListarProduto.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um produto.", "ERRO: Alterar Produto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Produto produto = proTableModel.getProduto(selectedRow);
        
        JTextField nomeField = new JTextField(produto.getNome());
        JTextField tamPesoField = new JTextField(String.valueOf(produto.getTam_pes()));
        JTextField valorField = new JTextField(String.valueOf(produto.getValor()));
        JTextField qtEstoqueField = new JTextField(String.valueOf(produto.getEstoque()));
        JComboBox<String> categoriaComboBox = new JComboBox<>(getCategoria());
        JComboBox<String> unidadeMedidaComboBox = new JComboBox<>(getUnidMedida());

        JPanel panel = new JPanel(new GridLayout(6, 2));

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Categoria:"));
        panel.add(categoriaComboBox);
        panel.add(new JLabel("Tamanho/Peso:"));
        panel.add(tamPesoField);
        panel.add(new JLabel("Unidade de Medida:"));
        panel.add(unidadeMedidaComboBox);
        panel.add(new JLabel("Valor:"));
        panel.add(valorField);
        panel.add(new JLabel("Quantidade em Estoque:"));
        panel.add(qtEstoqueField);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Alterar Produto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String novoNome = nomeField.getText();
            String novaCategoria = (String) categoriaComboBox.getSelectedItem();
            double novoTamPeso = Double.parseDouble(tamPesoField.getText());
            String novaUnidadeMedida = (String) unidadeMedidaComboBox.getSelectedItem();
            double novoValor = Double.parseDouble(valorField.getText());
            int novaQtEstoque = Integer.parseInt(qtEstoqueField.getText());

            if (!novoNome.isEmpty() && !novaCategoria.isEmpty() && novoTamPeso > 0 && !novaUnidadeMedida.isEmpty() && novoValor > 0 && novaQtEstoque >= 0) {
                GerenciadorDeInterface.getInstance().getDominio().alterarProduto(produto, novoNome, novoValor, novoTamPeso, novaUnidadeMedida, novaCategoria, novaQtEstoque);
                atualizarTabelaProduto();
                JOptionPane.showMessageDialog(this, "Produto alterado com sucesso.", "Alterar Produto", JOptionPane.INFORMATION_MESSAGE);
                setFalseButton();
            } else {
                JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos corretamente.", "ERRO: Alterar Produto", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btAlterarProdutoActionPerformed

    private void btPesquisarConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarConsultarClienteActionPerformed

        if (campoBuscaVazio()) {
            JOptionPane.showMessageDialog(this, "Digite algo para buscar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            atualizarTabelaProduto();
            return;
        }

        String pesquisa = fieldListarProdutos.getText().trim();

        try {
            List<Produto> produtosFiltrados = new ArrayList<>();
            List<Produto> produtos = GerenciadorDeInterface.getInstance().getDominio().listar(Produto.class);
            for (Produto produto : produtos) {
                if (produto.getNome().toLowerCase().contains(pesquisa.toLowerCase()) ||
                    produto.getCategoria().toLowerCase().contains(pesquisa.toLowerCase()) ||
                    String.valueOf(produto.getTam_pes()).contains(pesquisa) ||
                    produto.getUnidMedida().toLowerCase().contains(pesquisa.toLowerCase()) ||
                    String.valueOf(produto.getValor()).contains(pesquisa) ||
                    String.valueOf(produto.getEstoque()).contains(pesquisa) ||
                    String.valueOf(produto.getIdProduto()).contains(pesquisa)) {

                    produtosFiltrados.add(produto);
                }
            }

            if (produtosFiltrados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum produto encontrado com os critérios de busca.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                fieldListarProdutos.setText("");
                atualizarTabelaProduto();
            } else {
                proTableModel.setLista(produtosFiltrados);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar produtos: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btPesquisarConsultarClienteActionPerformed

    private void atualizarTabelaProduto() {
        try {
            List<Produto> produto = GerenciadorDeInterface.getInstance().getDominio().listar(Produto.class);
            Collections.sort(produto, Comparator.comparingInt(Produto::getIdProduto));  
            proTableModel.setLista(produto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + ex.getMessage(), "ERRO: Atualizar Lista Produtos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void setTrueButton(){
        btSelecionarProduto.setVisible(false);
        tbListarProduto.setEnabled(false);        
        btExcluirProduto.setVisible(true);
        btCancelarProduto.setVisible(true);
        btAlterarProduto.setVisible(true);
    }
    
    private void setFalseButton(){
        btSelecionarProduto.setVisible(true);  
        tbListarProduto.setEnabled(true);
        btExcluirProduto.setVisible(false);
        btCancelarProduto.setVisible(false);
        btAlterarProduto.setVisible(false);        
    }
    
    private String[] getCategoria() {
        return new String[] {"Café", "Chá", "Bebida", "Salgado", "Bolo", "Pão"};
    }

    private String[] getUnidMedida() {
        return new String[] {"g", "kg", "ml"};
    }
    
    private boolean campoBuscaVazio() {
        return fieldListarProdutos.getText().trim().isEmpty();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterarProduto;
    private javax.swing.JButton btCancelarProduto;
    private javax.swing.JButton btExcluirProduto;
    private javax.swing.JButton btPesquisarConsultarCliente;
    private javax.swing.JButton btSelecionarProduto;
    private javax.swing.JButton btVoltarListarProduto;
    private javax.swing.JTextField fieldListarProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labFundoListaProduto;
    private javax.swing.JScrollPane scrolConsultarCliente;
    private javax.swing.JTable tbListarProduto;
    // End of variables declaration//GEN-END:variables
}
