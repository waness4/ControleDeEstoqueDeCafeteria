package dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author wanes
 */
public class GenericDAO {
    
    public void inserir (Object obj) throws HibernateException{
        Session sessao= null;
        try{
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();
            sessao.save(obj);

            sessao.getTransaction().commit();
            sessao.close();
        }catch (HibernateException ex){
            if (sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
    }
    
    public List<Object> listar(Class classe) throws HibernateException {
        Session sessao = null;
        List lista = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            Criteria consulta = sessao.createCriteria(classe);
            lista = consulta.list();
                        
            sessao.getTransaction().commit();
            
        } catch( HibernateException erro) {
            if ( sessao != null ){
                sessao.getTransaction().rollback();
                sessao.close();
            }
        }
        return lista;
    }
    
}
