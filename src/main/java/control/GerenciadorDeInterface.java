package control;

import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import view.*;

/**
 *
 * @author wanes
 */
public class GerenciadorDeInterface {
    private FrmPrincipal frmPrincipal = null;
    private DlgConsultarCliente dlgCliente = null;
    private DlgConsultarFornecedor dlgFornecedor = null;
    private DlgPagamento dlgPagamento = null;
    private DlgMenu dlgMenu = null;
    
    private GerenciadorDeDominio dominio;
    
    private static GerenciadorDeInterface myInstance = new GerenciadorDeInterface();
    
    
    /*          CONSTRUTORES            */    
    
    private GerenciadorDeInterface() {
        try {
            dominio = new GerenciadorDeDominio();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frmPrincipal, "Erro de classe. " + ex.getMessage() );
            System.exit(0);                    
        }       
    }
    
    
    /*      GERENCIADOR DE DOMINIO        */
    
    public GerenciadorDeDominio getDominio() {
        return dominio;
    }
    
    /*      GERENCIADOR DE INTERFACE        */
    
    public static GerenciadorDeInterface getInstance() {
        return myInstance;       
    }
    
    
    
    /*         ABRIR JANELAS              */
    
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe) throws NoSuchMethodException {
        if (dlg == null || !dlg.isVisible()){     
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class, GerenciadorDeInterface.class).newInstance(parent,true, myInstance);
            } catch ( NoSuchMethodException ex) {
                throw ex;                
            } catch (Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName());
                System.exit(-1);
            }
        }else{
            dlg.requestFocus();
        }     
        dlg.setVisible(true); 
        return dlg;
    }
    
    public void abrirJanelaPrincipal(){
        if(frmPrincipal == null){
            frmPrincipal = new FrmPrincipal(this);
        }
        frmPrincipal.setVisible(true);
    }
    
    public void abrirJanelaDlgMenu() throws NoSuchMethodException{
        abrirJanela(frmPrincipal, dlgMenu, DlgMenu.class);
    }
    
    public void abrirJanelaDlgConsultarCliente() throws NoSuchMethodException{
        abrirJanela(frmPrincipal, dlgCliente, DlgConsultarCliente.class);
    }
    
    public void abrirJanelaDlgConsultarFornecedor() throws NoSuchMethodException{
        abrirJanela(frmPrincipal, dlgFornecedor, DlgConsultarFornecedor.class);
    }
    
    public void abrirJanelaDlgPagamento() throws NoSuchMethodException{
        abrirJanela(frmPrincipal, dlgPagamento, DlgPagamento.class);
    }    
    
    /*             MAIN              */
    
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        GerenciadorDeInterface myInstance = new GerenciadorDeInterface();
        myInstance.abrirJanelaPrincipal();
       
    }

}
