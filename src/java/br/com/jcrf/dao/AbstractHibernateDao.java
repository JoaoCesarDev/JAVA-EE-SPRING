/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcrf.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jcrfm
 * @param <T>
 */

public abstract class AbstractHibernateDao<T extends Serializable> {
    
    Class<T> clazz;
 
    @Autowired
    SessionFactory sessionFactory;
 
    public void setClazz(Class< T > clazzToSet){
       this.clazz = clazzToSet;
    }
 
    public T findOne(long id){
      return (T) getCurrentSession().get(clazz.getClass().getSimpleName(), id);
    }

    @SuppressWarnings("JPQLValidation")
    public List findAll() {
        return getCurrentSession().createQuery("from " + clazz.getClass().getSimpleName()).getResultList();
    }

    public T create(T entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    public T update(T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(long entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
