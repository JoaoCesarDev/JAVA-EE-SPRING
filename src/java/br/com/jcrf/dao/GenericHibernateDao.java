/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcrf.dao;

import br.com.jcrf.entity.bCrypt;
import br.com.jcrf.entity.Usuario;
import java.io.Serializable;
import java.util.List;
import org.hibernate.query.Query;
import org.mindrot.BCrypt;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


/**
 *
 * @author jcrfm
 * @param <T>
 */
@Repository

@Scope(BeanDefinition.SCOPE_PROTOTYPE)

public class GenericHibernateDao<T extends Serializable> extends AbstractHibernateDao<T> implements DaoInterface{
    
  
    @Override
    public void insert(Object obj) {
       getCurrentSession().saveOrUpdate(obj);
    }
    
    
    @Override
    public void update(Object obj) {
        getCurrentSession().merge(obj);
    }
    
   
    @Override
    public void remove(Object obj) {
        getCurrentSession().delete(obj);
    }

    @Override
    public Object procura(Object obj, Long id) {
        return (T) getCurrentSession().get(obj.getClass(), id);
    }
    
    public boolean existe(String login, String senha, Object obj) {
       try{
      @SuppressWarnings("JPQLValidation")
      Usuario user = (Usuario)getCurrentSession().createQuery("from "+ obj.getClass().getSimpleName() + " u where u.login = :login")
                    .setParameter("login", login)
                    .uniqueResult();
      
       if(BCrypt.checkpw(senha, user.getSenha()))
           return true;
       return false;
       }catch(Exception e){
        System.out.println("Erro" + e.getMessage());
       }
    return false;
    }   
    
    public Object perfil(Object obj, String login) {
       @SuppressWarnings("JPQLValidation")
       Query q = getCurrentSession().createQuery("select u from "+ obj.getClass().getSimpleName() + " u where u.login = :login");
       
       q.setParameter("login",login);
       
       return q.getSingleResult();
       
    }

    @Override
    public List findall(Object obj) {
        
        @SuppressWarnings("JPQLValidation")
        Query q = getCurrentSession().createQuery("from "+ obj.getClass().getSimpleName());
                
        List<T> lista = q.list();
         
        return lista;
    }

    
}
