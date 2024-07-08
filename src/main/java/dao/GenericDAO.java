package dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

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
            
        }catch (HibernateException ex){
            if (sessao != null){
                sessao.getTransaction().rollback();
            }
            throw new HibernateException(ex);
        } finally {
            if (sessao != null) {
                sessao.close();
            }
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
            }
        }finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return lista;
    }
    
    public void alterar(Object obj) throws HibernateException {
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();
            
            sessao.update(obj);
            
            sessao.getTransaction().commit();
            
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
            }
            throw new HibernateException(ex);
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }
    
    public List<Object> pesquisar(Class classe, Criterion criterio) throws HibernateException {
        Session sessao = null;
        List<Object> resultado = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            Criteria consulta = sessao.createCriteria(classe);
            consulta.add(criterio);

            resultado = consulta.list();

            sessao.getTransaction().commit();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
            }
            throw new HibernateException(ex);
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return resultado;
    }
}
