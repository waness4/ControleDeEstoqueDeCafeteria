package view;

import control.ClienteAbstractTableModel;
import control.GerenciadorDeInterface;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Cliente;

/**
 *
 * @author wanes
 */
public class Dlg_Listar_Clientes extends javax.swing.JDialog {

    private GerenciadorDeInterface inter;
    private ClienteAbstractTableModel cliTableModel;
    private Cliente cliSelecionado = null;
    
    public Dlg_Listar_Clientes(java.awt.Frame parent, boolean modal, GerenciadorDeInterface inter) {
        super(parent, modal);
        initComponents();
        this.inter = inter;        
        cliTableModel = new ClienteAbstractTableModel();
        tbListarCliente.setModel((TableModel) cliTableModel);        
        atualizarTabelaCliente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btVoltarConsultarCliente = new javax.swing.JButton();
        fieldDescricaoConsultarCliente = new javax.swing.JTextField();
        scrolConsultarCliente = new javax.swing.JScrollPane();
        tbListarCliente = new javax.swing.JTable();
        btBuscarCliente = new javax.swing.JButton();
        labListaClientes = new javax.swing.JLabel();
        btSelecionarCliente = new javax.swing.JButton();
        labFundoListaCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btVoltarConsultarCliente.setText("Voltar");
        btVoltarConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarConsultarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltarConsultarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 70, 30));
        getContentPane().add(fieldDescricaoConsultarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 220, 30));

        tbListarCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "CPF", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrolConsultarCliente.setViewportView(tbListarCliente);

        getContentPane().add(scrolConsultarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 540, 180));

        btBuscarCliente.setText("Buscar");
        btBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 80, 30));

        labListaClientes.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        labListaClientes.setText("LISTA CLIENTES");
        getContentPane().add(labListaClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        btSelecionarCliente.setText("Selecionar");
        btSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btSelecionarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 110, 30));

        labFundoListaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagem-fundo-2.png"))); // NOI18N
        getContentPane().add(labFundoListaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarConsultarClienteActionPerformed
        //Torna o Dlg_Menu invisivel
        this.setVisible(false);

        try {
            inter.abrirJanelaDlg_Menu();
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btVoltarConsultarClienteActionPerformed

    private void btSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarClienteActionPerformed
        // TODO add your handling code here:
        int linha = tbListarCliente.getSelectedRow();
        if(linha >=0){
            linha = tbListarCliente.convertRowIndexToModel(linha);
            cliSelecionado = cliTableModel.getCliente(linha);
        } else{
            JOptionPane.showMessageDialog(this,"Selecione uma linha da tabela.", "Pesquisar produto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btSelecionarClienteActionPerformed

    private void btBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarClienteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btBuscarClienteActionPerformed

    private void atualizarTabelaCliente() {
        try {
            List<Cliente> clientes = GerenciadorDeInterface.getInstance().getDominio().listar(Cliente.class);
            cliTableModel.setLista(clientes);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar clientes: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarCliente;
    private javax.swing.JButton btSelecionarCliente;
    private javax.swing.JButton btVoltarConsultarCliente;
    private javax.swing.JTextField fieldDescricaoConsultarCliente;
    private javax.swing.JLabel labFundoListaCliente;
    private javax.swing.JLabel labListaClientes;
    private javax.swing.JScrollPane scrolConsultarCliente;
    private javax.swing.JTable tbListarCliente;
    // End of variables declaration//GEN-END:variables

}