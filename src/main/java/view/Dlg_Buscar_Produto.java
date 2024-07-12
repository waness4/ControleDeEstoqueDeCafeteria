package view;


import control.GerenciadorDeInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wanes
 */
public class Dlg_Buscar_Produto extends javax.swing.JDialog {

    private GerenciadorDeInterface inter;
    /**
     * Creates new form Dlg_Buscar_Produto
     */
    public Dlg_Buscar_Produto(java.awt.Frame parent, boolean modal, GerenciadorDeInterface inter) {
        super(parent, modal);
        initComponents();
        this.inter = inter;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labSelecionarProduto = new javax.swing.JLabel();
        btVoltarBuscarProduto = new javax.swing.JButton();
        fieldBuscarProduto = new javax.swing.JTextField();
        btBuscarProduto = new javax.swing.JButton();
        scrolConsultarCliente = new javax.swing.JScrollPane();
        tbBuscarProduto = new javax.swing.JTable();
        btnSelecionarProduto = new javax.swing.JButton();
        labFundoBuscarProduto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labSelecionarProduto.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        labSelecionarProduto.setText("SELECIONAR PRODUTO");
        getContentPane().add(labSelecionarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        btVoltarBuscarProduto.setText("Voltar");
        btVoltarBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarBuscarProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltarBuscarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 70, 30));
        getContentPane().add(fieldBuscarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 220, 30));

        btBuscarProduto.setText("Buscar");
        btBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btBuscarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 80, 30));

        tbBuscarProduto.setModel(new javax.swing.table.DefaultTableModel(
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
        scrolConsultarCliente.setViewportView(tbBuscarProduto);

        getContentPane().add(scrolConsultarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 540, 180));

        btnSelecionarProduto.setText("Selecionar");
        btnSelecionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelecionarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 110, 30));

        labFundoBuscarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagem-fundo-2.png"))); // NOI18N
        getContentPane().add(labFundoBuscarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarBuscarProdutoActionPerformed
        this.setVisible(false);
        try {
            inter.abrirJanelaDlg_Menu();
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btVoltarBuscarProdutoActionPerformed

    private void btnSelecionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarProdutoActionPerformed
        int linha = tbBuscarProduto.getSelectedRow();
        if(linha >=0){
            linha = tbBuscarProduto.convertRowIndexToModel(linha);
            //proSelecionado = proTableModel.getProduto(linha);
        } else{
            JOptionPane.showMessageDialog(this,"Selecione uma linha da tabela.", "Selecionar Produto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSelecionarProdutoActionPerformed

    private void btBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btBuscarProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarProduto;
    private javax.swing.JButton btVoltarBuscarProduto;
    private javax.swing.JButton btnSelecionarProduto;
    private javax.swing.JTextField fieldBuscarProduto;
    private javax.swing.JLabel labFundoBuscarProduto;
    private javax.swing.JLabel labSelecionarProduto;
    private javax.swing.JScrollPane scrolConsultarCliente;
    private javax.swing.JTable tbBuscarProduto;
    // End of variables declaration//GEN-END:variables
}
