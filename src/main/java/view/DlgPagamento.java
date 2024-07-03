/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

/**
 *
 * @author wanes
 */
public class DlgPagamento extends javax.swing.JDialog {

    /**
     * Creates new form DlgPagamento
     */
    public DlgPagamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panTipoPagamento = new javax.swing.JPanel();
        rbDinheiroPagamento = new javax.swing.JRadioButton();
        rbCartaoPagamento = new javax.swing.JRadioButton();
        tbParcelar = new javax.swing.JRadioButton();
        rbAVista = new javax.swing.JRadioButton();
        fieldQtPagamento = new javax.swing.JTextField();
        labQtPagamento = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        labPagamento = new javax.swing.JLabel();
        panRealizarPagamento = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fieldTotalPagamento = new javax.swing.JTextField();
        labTrocoPagamento = new javax.swing.JLabel();
        fieldTrocoPagamento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaObservacoes = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        labObservacoes = new javax.swing.JLabel();
        btCancelarPagamento = new javax.swing.JButton();
        btFinalizarPagamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panTipoPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Formas de Pagamento"));
        panTipoPagamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbDinheiroPagamento.setText("Dinheiro");
        rbDinheiroPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDinheiroPagamentoActionPerformed(evt);
            }
        });
        panTipoPagamento.add(rbDinheiroPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        rbCartaoPagamento.setText("Cartão");
        rbCartaoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCartaoPagamentoActionPerformed(evt);
            }
        });
        panTipoPagamento.add(rbCartaoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        tbParcelar.setText("Parcelar");
        tbParcelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbParcelarActionPerformed(evt);
            }
        });
        panTipoPagamento.add(tbParcelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        rbAVista.setText("À vista");
        panTipoPagamento.add(rbAVista, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));
        panTipoPagamento.add(fieldQtPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 50, -1));

        labQtPagamento.setText("Qt vezes:");
        panTipoPagamento.add(labQtPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));
        panTipoPagamento.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 240, 10));

        getContentPane().add(panTipoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 240, 270));
        panTipoPagamento.getAccessibleContext().setAccessibleName("");

        labPagamento.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        labPagamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPagamento.setText("PAGAMENTO");
        getContentPane().add(labPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 3, 650, 80));

        panRealizarPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Finalizar"));
        panRealizarPagamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Total:");
        panRealizarPagamento.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 37, -1));
        panRealizarPagamento.add(fieldTotalPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 59, -1));

        labTrocoPagamento.setText("Troco:");
        panRealizarPagamento.add(labTrocoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        fieldTrocoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTrocoPagamentoActionPerformed(evt);
            }
        });
        panRealizarPagamento.add(fieldTrocoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 60, -1));

        areaObservacoes.setColumns(20);
        areaObservacoes.setRows(5);
        jScrollPane1.setViewportView(areaObservacoes);

        panRealizarPagamento.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 220, 120));
        panRealizarPagamento.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 240, 10));

        labObservacoes.setText("Observações:");
        panRealizarPagamento.add(labObservacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        getContentPane().add(panRealizarPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 240, 270));

        btCancelarPagamento.setText("Cancelar");
        btCancelarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarPagamentoActionPerformed(evt);
            }
        });
        getContentPane().add(btCancelarPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 110, 30));

        btFinalizarPagamento.setText("Finalizar");
        btFinalizarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarPagamentoActionPerformed(evt);
            }
        });
        getContentPane().add(btFinalizarPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 110, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbDinheiroPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDinheiroPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbDinheiroPagamentoActionPerformed

    private void rbCartaoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCartaoPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCartaoPagamentoActionPerformed

    private void tbParcelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbParcelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbParcelarActionPerformed

    private void fieldTrocoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTrocoPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTrocoPagamentoActionPerformed

    private void btCancelarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarPagamentoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btCancelarPagamentoActionPerformed

    private void btFinalizarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarPagamentoActionPerformed
        // TODO add your handling code here:

        //Salvar infos na tabela Historico de Venda

        //Dar baixa no estoque dos itens comprados

    }//GEN-LAST:event_btFinalizarPagamentoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaObservacoes;
    private javax.swing.JButton btCancelarPagamento;
    private javax.swing.JButton btFinalizarPagamento;
    private javax.swing.JTextField fieldQtPagamento;
    private javax.swing.JTextField fieldTotalPagamento;
    private javax.swing.JTextField fieldTrocoPagamento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labObservacoes;
    private javax.swing.JLabel labPagamento;
    private javax.swing.JLabel labQtPagamento;
    private javax.swing.JLabel labTrocoPagamento;
    private javax.swing.JPanel panRealizarPagamento;
    private javax.swing.JPanel panTipoPagamento;
    private javax.swing.JRadioButton rbAVista;
    private javax.swing.JRadioButton rbCartaoPagamento;
    private javax.swing.JRadioButton rbDinheiroPagamento;
    private javax.swing.JRadioButton tbParcelar;
    // End of variables declaration//GEN-END:variables
}