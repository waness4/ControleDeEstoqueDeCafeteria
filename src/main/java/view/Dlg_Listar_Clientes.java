package view;

import control.ClienteAbstractTableModel;
import control.GerenciadorDeInterface;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import model.Cliente;
import org.hibernate.HibernateException;

/**
 *
 * @author wanes
 */
public class Dlg_Listar_Clientes extends javax.swing.JDialog {

    private ClienteAbstractTableModel cliTableModel;
    private Cliente cliSelecionado = null;
    
    public Dlg_Listar_Clientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();  
        cliTableModel = new ClienteAbstractTableModel();
        tbListarCliente.setModel((TableModel) cliTableModel);        
        atualizarTabelaCliente();
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

        btVoltarListarCliente = new javax.swing.JButton();
        fieldListarCliente = new javax.swing.JTextField();
        scrolConsultarCliente = new javax.swing.JScrollPane();
        tbListarCliente = new javax.swing.JTable();
        btBuscarCliente = new javax.swing.JButton();
        labListaClientes = new javax.swing.JLabel();
        btExcluirCliente = new javax.swing.JButton();
        btAlterarCliente = new javax.swing.JButton();
        btSelecionarCliente = new javax.swing.JButton();
        btCancelarCliente = new javax.swing.JButton();
        labFundoListaCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btVoltarListarCliente.setText("Voltar");
        btVoltarListarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarListarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltarListarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 70, 30));

        fieldListarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldListarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(fieldListarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 220, 30));

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
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbListarCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrolConsultarCliente.setViewportView(tbListarCliente);

        getContentPane().add(scrolConsultarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 540, 180));

        btBuscarCliente.setText("Buscar");
        btBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 80, 30));

        labListaClientes.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        labListaClientes.setText("LISTA CLIENTES");
        getContentPane().add(labListaClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        btExcluirCliente.setText("Excluir");
        btExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btExcluirCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 110, 30));

        btAlterarCliente.setText("Alterar");
        btAlterarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btAlterarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 110, 30));

        btSelecionarCliente.setText("Selecionar");
        btSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btSelecionarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 110, 30));

        btCancelarCliente.setText("Cancelar");
        btCancelarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btCancelarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 110, 30));

        labFundoListaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagem-fundo-2.png"))); // NOI18N
        getContentPane().add(labFundoListaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarListarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarListarClienteActionPerformed
        
        this.setVisible(false);
        abrirJanelaMenu();
        
    }//GEN-LAST:event_btVoltarListarClienteActionPerformed

    private void abrirJanelaMenu() {
        try {
            GerenciadorDeInterface.getInstance().abrirJanelaDlg_Menu();
        } catch (NoSuchMethodException ex) {
            mostrarErro("Erro ao abrir o menu principal", ex);
        }
    }
    
    private void btExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirClienteActionPerformed
        
        int selectedRow = tbListarCliente.getSelectedRow();
        if (selectedRow < 0) {
            mostrarMensagem("Selecione um cliente.", "ERRO: Excluir Cliente", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = cliTableModel.getCliente(selectedRow);
        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o cliente " + cliente.getNome() + "?", "Excluir Cliente", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                excluirCliente(cliente);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Dlg_Listar_Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btExcluirClienteActionPerformed

    private void excluirCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
        
        try {
            boolean temReferencias = GerenciadorDeInterface.getInstance().getDominio().clienteTemReferencias(cliente);
            if (temReferencias) {
                mostrarMensagem("Não é possível excluir o cliente. Ele está referenciado por outras entidades.", "ERRO: Excluir Cliente", JOptionPane.ERROR_MESSAGE);
                return;
            }

            GerenciadorDeInterface.getInstance().getDominio().excluirCliente(cliente);
            atualizarTabelaCliente();
            mostrarMensagem("Cliente excluído com sucesso.", "Excluir Cliente", JOptionPane.INFORMATION_MESSAGE);
            setFalseButton();
        } catch (HibernateException ex) {
            mostrarErro("Erro ao excluir cliente: " + ex.getMessage(), ex);
        }
        
    }
    
    private void btBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarClienteActionPerformed

        if (campoBuscaVazio()) {
            mostrarMensagem("Digite algo para buscar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            atualizarTabelaCliente();
            return;
        }
        buscarCliente(fieldListarCliente.getText().trim());
        
    }//GEN-LAST:event_btBuscarClienteActionPerformed

    private void buscarCliente(String pesquisa) {
        
        try {
            List<Cliente> clientesFiltrados = new ArrayList<>();
            List<Cliente> clientes = GerenciadorDeInterface.getInstance().getDominio().listar(Cliente.class);
            for (Cliente cliente : clientes) {
                if (cliente.getNome().toLowerCase().contains(pesquisa.toLowerCase()) ||
                    cliente.getTel().toLowerCase().contains(pesquisa.toLowerCase()) ||
                    cliente.getCpf().toLowerCase().contains(pesquisa.toLowerCase()) ||
                    String.valueOf(cliente.getIdCliente()).toLowerCase().contains(pesquisa.toLowerCase())) {

                    clientesFiltrados.add(cliente);
                }
            }

            if (clientesFiltrados.isEmpty()) {
                mostrarMensagem("Nenhum cliente encontrado com os critérios de busca.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                fieldListarCliente.setText("");
                atualizarTabelaCliente();
            } else {
                cliTableModel.setLista(clientesFiltrados);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            mostrarErro("Erro ao buscar clientes: " + ex.getMessage(), ex);
        }
        
    }
    
    private void btAlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarClienteActionPerformed

        int selectedRow = tbListarCliente.getSelectedRow();
        if (selectedRow < 0) {
            mostrarMensagem("Selecione um cliente.", "ERRO: Alterar Cliente", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Cliente cliente = cliTableModel.getCliente(selectedRow);
        alterarCliente(cliente);
        
    }//GEN-LAST:event_btAlterarClienteActionPerformed

    private void alterarCliente(Cliente cliente) {
        
        JTextField nomeField = new JTextField(cliente.getNome());
        JTextField cpfField = new JTextField(cliente.getCpf());
        JTextField telField = new JTextField(cliente.getTel());

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("CPF:"));
        panel.add(cpfField);
        panel.add(new JLabel("Telefone:"));
        panel.add(telField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Alterar Cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            if (camposValidos(nomeField, cpfField, telField)) {
                try {
                    GerenciadorDeInterface.getInstance().getDominio().alterarCliente(cliente, nomeField.getText(), cpfField.getText(), telField.getText());
                    atualizarTabelaCliente();
                    mostrarMensagem("Cliente alterado com sucesso.", "Alterar Cliente", JOptionPane.INFORMATION_MESSAGE);
                    setFalseButton();
                } catch (HibernateException ex) {
                    mostrarErro("Erro ao alterar cliente: " + ex.getMessage(), ex);
                }
            } else {
                mostrarMensagem("Todos os campos devem ser preenchidos.", "ERRO: Alterar Cliente", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    private boolean camposValidos(JTextField... campos) {
        
        for (JTextField campo : campos) {
            if (campo.getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
        
    }
    
    private void btSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarClienteActionPerformed
        
        int selectedRow = tbListarCliente.getSelectedRow();
        if (selectedRow < 0) {
            mostrarMensagem("Selecione um cliente.", "ERRO: Selecionar Cliente", JOptionPane.ERROR_MESSAGE);
        } else {
            setTrueButton();
        }   
        
    }//GEN-LAST:event_btSelecionarClienteActionPerformed

    private void btCancelarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarClienteActionPerformed
        setFalseButton();
    }//GEN-LAST:event_btCancelarClienteActionPerformed

    private void fieldListarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldListarClienteActionPerformed
        
    }//GEN-LAST:event_fieldListarClienteActionPerformed

    private void atualizarTabelaCliente() {
        
        try {
            List<Cliente> clientes = GerenciadorDeInterface.getInstance().getDominio().listar(Cliente.class);
            Set<Cliente> clienteSet = new LinkedHashSet<>(clientes); 
            clientes = new ArrayList<>(clienteSet); 
            Collections.sort(clientes, Comparator.comparingInt(Cliente::getIdCliente));
            cliTableModel.setLista(clientes);
        } catch (ClassNotFoundException | SQLException ex) {
            mostrarErro("Erro ao carregar clientes: " + ex.getMessage(), ex);
        }
        
    }
    
    private void setTrueButton() {
        btSelecionarCliente.setVisible(false);
        tbListarCliente.setEnabled(false);
        btExcluirCliente.setVisible(true);
        btCancelarCliente.setVisible(true);
        btAlterarCliente.setVisible(true);
    }

    private void setFalseButton() {
        btSelecionarCliente.setVisible(true);
        tbListarCliente.setEnabled(true);
        btExcluirCliente.setVisible(false);
        btCancelarCliente.setVisible(false);
        btAlterarCliente.setVisible(false);
    }

    private boolean campoBuscaVazio() {
        return fieldListarCliente.getText().trim().isEmpty();
    }
    
    private void mostrarMensagem(String mensagem, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, mensagem, titulo, tipo);
    }

    private void mostrarErro(String mensagem, Exception ex) {
        Logger.getLogger(Dlg_Listar_Clientes.class.getName()).log(Level.SEVERE, mensagem, ex);
        mostrarMensagem(mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterarCliente;
    private javax.swing.JButton btBuscarCliente;
    private javax.swing.JButton btCancelarCliente;
    private javax.swing.JButton btExcluirCliente;
    private javax.swing.JButton btSelecionarCliente;
    private javax.swing.JButton btVoltarListarCliente;
    private javax.swing.JTextField fieldListarCliente;
    private javax.swing.JLabel labFundoListaCliente;
    private javax.swing.JLabel labListaClientes;
    private javax.swing.JScrollPane scrolConsultarCliente;
    private javax.swing.JTable tbListarCliente;
    // End of variables declaration//GEN-END:variables
}
