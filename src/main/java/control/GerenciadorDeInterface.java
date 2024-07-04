package control;

import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import view.*;

/**
 *
 * @author wanes
 */
public class GerenciadorDeInterface {
    private Main_Frame main_frame = null;
    private Dlg_Listar_Clientes dlg_clientes = null;
    private Dlg_Listar_Produtos dlg_produtos = null;
    private Dlg_Menu dlg_menu = null;
    
    private GerenciadorDeDominio dominio;
    
    private static GerenciadorDeInterface myInstance = new GerenciadorDeInterface();
    
    
    /*          CONSTRUTORES            */    
    
    private GerenciadorDeInterface() {
        try {
            dominio = new GerenciadorDeDominio();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(main_frame, "Erro de classe. " + ex.getMessage() );
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
            } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | SecurityException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() + ": " + ex.getMessage());
                ex.printStackTrace(); 
                System.exit(-1);
            }
        }else{
            dlg.requestFocus();
        }     
        dlg.setVisible(true); 
        return dlg;
    }
    
    public void abrirJanelaMain_Frame(){
        if(main_frame == null){
            main_frame = new Main_Frame(this);
        }
        main_frame.setVisible(true);
    }
    
    public void abrirJanelaDlg_Menu() throws NoSuchMethodException{
        abrirJanela(main_frame, dlg_menu, Dlg_Menu.class);
    }
    
    public void abrirJanelaDlg_Listar_Clientes() throws NoSuchMethodException{
        abrirJanela(main_frame, dlg_clientes, Dlg_Listar_Clientes.class);
    }
    
    public void abrirJanelaDlg_Listar_Produtos() throws NoSuchMethodException{
        abrirJanela(main_frame, dlg_produtos, Dlg_Listar_Produtos.class);
    }
    
    /*             MAIN              */
    
    public static void main(String args[]) throws ClassNotFoundException {
        myInstance.abrirJanelaMain_Frame();       
    }

}
