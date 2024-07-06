/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.GerenciadorDeInterface;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author wanes
 */
public class Main_Frame extends javax.swing.JFrame {

    private GerenciadorDeInterface inter;
    /**
     * Creates new form FrmPrincipal
     * @param newGInterface
     */
    public Main_Frame(GerenciadorDeInterface newGInterface) {
        inter = newGInterface;
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

        btIniciar = new javax.swing.JToggleButton();
        labImagemFundoMain = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btIniciar.setBackground(new java.awt.Color(204, 204, 204));
        btIniciar.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btIniciar.setText("INICIAR APLICAÇÃO");
        btIniciar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btIniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btIniciarMouseClicked(evt);
            }
        });
        btIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 155, 250, 90));

        labImagemFundoMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagem-fundo-1.png"))); // NOI18N
        getContentPane().add(labImagemFundoMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btIniciarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btIniciarMouseClicked

    private void btIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarActionPerformed
        //Torna o Main_Frame invisivel
        this.setVisible(false);

        try {
            inter.abrirJanelaDlg_Menu();
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }//GEN-LAST:event_btIniciarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btIniciar;
    private javax.swing.JLabel labImagemFundoMain;
    // End of variables declaration//GEN-END:variables
}
