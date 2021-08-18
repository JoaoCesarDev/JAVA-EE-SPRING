/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcrf.dao;

import br.com.jcrf.entity.Usuario;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author jcrfm
 */


public class UsuarioDao implements DaoInterface<Usuario>{

    
    private Session session;
    
    private Class classe;
    
    public UsuarioDao(Session session,Class classe) {
        this.session = session;
        this.classe = classe;
    }
    
   
    @Override
    public void insert(Usuario obj) {
      
        session.save(obj);
       
    }

    @Override
    public void update(Usuario obj) {
        
        session.merge(obj);
        
    }
   
    @Override
    public void remove(Usuario obj) {
       
        session.delete(obj);
        
    }

    @Override
    public Usuario procura(Usuario obj,Long id) {
       
         return (Usuario) session.load(this.classe, id);
        
    }
    
    public boolean existe(String login,String senha,Usuario obj) {
        boolean resultado = true;  
      
      @SuppressWarnings("JPQLValidation")
      Query q = session.createQuery("from "+ obj.getClass().getSimpleName() + " u where u.login = :login and u.senha = :senha");
      
      q.setParameter("login",login);
      q.setParameter("senha",senha);
      
      List<Usuario> usuarios = (List<Usuario>) q.getResultList();
      
        if (usuarios == null || usuarios.isEmpty()) {
            return false;
        }
      
      return resultado;
    }

    
    public List<Usuario> listaTudo() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        // create Criteria
        CriteriaQuery<Usuario> criteriaQuery = builder.createQuery(this.classe);
        
        criteriaQuery.from(this.classe);
        
        List<Usuario> usuarios = session.createQuery(criteriaQuery).getResultList();
       
        session.close();
        
        return usuarios;
    }


    @Override
    public List<Usuario> findall(Usuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
