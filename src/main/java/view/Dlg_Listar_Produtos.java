package view;

import control.ClienteAbstractTableModel;
import control.GerenciadorDeInterface;
import control.ProdutoAbstractTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Produto;

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
        btVoltarConsultarCliente = new javax.swing.JButton();
        fieldDescricaoConsultarCliente = new javax.swing.JTextField();
        btPesquisarConsultarCliente = new javax.swing.JButton();
        scrolConsultarCliente = new javax.swing.JScrollPane();
        tbListarProduto = new javax.swing.JTable();
        btnSelecionarCli = new javax.swing.JButton();
        labFundoListaProduto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel1.setText("LISTA PRODUTOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        btVoltarConsultarCliente.setText("Voltar");
        btVoltarConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarConsultarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltarConsultarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 70, 30));
        getContentPane().add(fieldDescricaoConsultarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 220, 30));

        btPesquisarConsultarCliente.setText("Buscar");
        getContentPane().add(btPesquisarConsultarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 70, 30));

        tbListarProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Tam/Pes", "Medida", "Estoque", "Preço Unid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrolConsultarCliente.setViewportView(tbListarProduto);

        getContentPane().add(scrolConsultarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 540, 180));

        btnSelecionarCli.setText("Selecionar");
        btnSelecionarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarCliActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelecionarCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 110, 30));

        labFundoListaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagem-fundo-2.png"))); // NOI18N
        getContentPane().add(labFundoListaProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarCliActionPerformed
        int linha = tbListarProduto.getSelectedRow();
        if(linha >=0){
            linha = tbListarProduto.convertRowIndexToModel(linha);
            proSelecionado = proTableModel.getProduto(linha);
        } else{
            JOptionPane.showMessageDialog(this,"Selecione uma linha da tabela.", "Pesquisar produto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSelecionarCliActionPerformed

    
    private void btVoltarConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarConsultarClienteActionPerformed
        
        //Torna o Dlg_Menu invisivel
        this.setVisible(false);

        try {
            inter.abrirJanelaDlg_Menu();
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btVoltarConsultarClienteActionPerformed

    private void atualizarTabelaProduto() {
        try {
            List<Produto> clientes = GerenciadorDeInterface.getInstance().getDominio().listar(Produto.class);
            proTableModel.setLista(clientes); // Atualiza o modelo de tabela com a lista de clientes
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar clientes: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisarConsultarCliente;
    private javax.swing.JButton btVoltarConsultarCliente;
    private javax.swing.JButton btnSelecionarCli;
    private javax.swing.JTextField fieldDescricaoConsultarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labFundoListaProduto;
    private javax.swing.JScrollPane scrolConsultarCliente;
    private javax.swing.JTable tbListarProduto;
    // End of variables declaration//GEN-END:variables
}
